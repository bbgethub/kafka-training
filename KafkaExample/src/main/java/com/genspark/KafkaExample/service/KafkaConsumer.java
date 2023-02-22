package com.genspark.KafkaExample.service;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
public class KafkaConsumer {
    public static final Logger LOGGER= (Logger) LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics="test2",groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("message received -> %s",message));
    }
}
