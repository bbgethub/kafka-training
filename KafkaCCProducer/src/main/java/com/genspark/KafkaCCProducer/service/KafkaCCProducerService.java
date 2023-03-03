package com.genspark.KafkaCCProducer.service;

import com.genspark.KafkaCCProducer.model.CurrencyConversion;
import com.genspark.KafkaCCProducer.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaCCProducerService {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaCCProducerService.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    public CurrencyConversion convertCurrency(String from, String to, long quantity) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        String url="http://localhost:8000/api/currency-exchange/from/{from}/to/{to}";
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
                url, CurrencyConversion.class,
                uriVariables);
        CurrencyConversion response = responseEntity.getBody();
        double totalAmount=response.getConversionMultiple()*quantity;
        CurrencyConversion currencyConversion=new CurrencyConversion(response.getId(), from, to,  response.getPort(), response.getConversionMultiple(),quantity,
                totalAmount);
        LOGGER.info(String.format("Message sent ->%s", currencyConversion));
        Message<CurrencyConversion> message= MessageBuilder
                .withPayload(currencyConversion)
                .setHeader(KafkaHeaders.TOPIC, AppConstants.TOPIC_NAME)
                .build();
        kafkaTemplate.send(message);
        return currencyConversion;
    }
}
