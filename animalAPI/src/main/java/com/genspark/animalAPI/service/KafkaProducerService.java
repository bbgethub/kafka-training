package com.genspark.animalAPI.service;

import com.genspark.animalAPI.model.Animal;
import com.genspark.animalAPI.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducerService.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    public Animal sendMessage(Animal animal) {
        LOGGER.info(String.format("Message sent ->%s", animal));
        Message<Animal> message= MessageBuilder
                .withPayload(animal)
                .setHeader(KafkaHeaders.TOPIC,AppConstants.TOPIC_NAME)
                .build();
        kafkaTemplate.send(message);
        return animal;
    }
}
