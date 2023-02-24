package com.genspark.KafkaWikimediaProject.kafka;

import com.genspark.KafkaWikimediaProject.util.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = AppConstant.TOPIC_NAME,groupId = AppConstant.GROUP_ID)
    public String consume(String message){
        LOGGER.info(String.format("Message Received -> %s",message));
        return message;
    }

}
