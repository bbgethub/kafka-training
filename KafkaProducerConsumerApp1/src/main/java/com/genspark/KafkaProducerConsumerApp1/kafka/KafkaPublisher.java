package com.genspark.KafkaProducerConsumerApp1.kafka;

import com.genspark.KafkaProducerConsumerApp1.model.User;
import com.genspark.KafkaProducerConsumerApp1.util.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class KafkaPublisher {
    private static Logger LOGGER= LoggerFactory.getLogger(KafkaPublisher.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    public void sendMessage(User data) {
        LOGGER.info(String.format("Message sent-> %s", data.toString()));
        Message<User> message= MessageBuilder.withPayload(data) //Create a new builder for a message with the given payload
                .setHeader(KafkaHeaders.TOPIC, AppConstant.TOPIC_NAME)
                .build();
        kafkaTemplate.send(message);
    }
}
