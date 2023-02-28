package com.genspark.animalAPI.service;

import com.genspark.animalAPI.model.Animal;
import com.genspark.animalAPI.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumerService.class);
    Animal animalFromTopic=null;
    public Animal getAnimalFromTopic()
    {
        return animalFromTopic;
    }
    @KafkaListener(topics = AppConstants.TOPIC_NAME,groupId = AppConstants.GROUP_ID,containerFactory = "concurrentKafkaListenerContainerFactory")
    public void consumeMessage(Animal animal){
        animalFromTopic=animal;
        LOGGER.info(String.format("message consumed -> %s",animal.toString()));
    }
}
