package com.genspark.EmailService.KafkaService;

import com.genspark.MainProject.DTO.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderConsumerService {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaOrderConsumerService.class);
    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent)
    {
        LOGGER.info(String.format("OrderEvent received in EmailService -> %s",orderEvent.toString()));
        System.out.println(orderEvent.toString());
    }
}
