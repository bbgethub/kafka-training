package com.genspark.KafkaProducerConsumerApp1.kafka;

import com.genspark.KafkaProducerConsumerApp1.model.User;
import com.genspark.KafkaProducerConsumerApp1.util.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);
    User userFromTopic=null;
    public User getUserFromTopic()
    {
        return userFromTopic;
    }
    @KafkaListener(topics = AppConstant.TOPIC_NAME,groupId = AppConstant.GROUP_ID,containerFactory = "concurrentKafkaListenerContainerFactory")
    public void consumeMessage(User user){
        userFromTopic=user;
        LOGGER.info(String.format("message consumed -> %s",user.toString()));
    }
}
