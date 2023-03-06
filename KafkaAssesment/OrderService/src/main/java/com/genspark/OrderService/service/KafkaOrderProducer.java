package com.genspark.OrderService.service;

import com.genspark.MainProject.DTO.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import util.AppConstants;

@Service
public class KafkaOrderProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaOrderProducer.class);
    private NewTopic topic;
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public KafkaOrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(OrderEvent orderEvent)
    {
        LOGGER.info(String.format("OrderEvent -> %s",orderEvent));
        Message<OrderEvent> message= MessageBuilder.withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC, AppConstants.TOPIC_NAME).build();
        kafkaTemplate.send(message);

    }
}
