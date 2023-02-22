package com.genspark.KafkaExample3.Kafka;

import com.genspark.KafkaExample3.Model.User;
import com.genspark.KafkaExample3.Util.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafaConsumer.class);
//  @KafkaListener(topics = AppConstant.TOPIC_NAME,groupId = AppConstant.GROUP_ID)
//    public void consumeMessage(User user)
//    {
//        LOGGER.info(String.format("Message received -> %s",user.toString()));
//    }
    @KafkaListener(topics = AppConstant.TOPIC_NAME,groupId = AppConstant.GROUP_ID)
public void receive(@Payload User data, @Headers MessageHeaders headers) {
 LOGGER.info("received data='{}'", data);
 headers.keySet().forEach(key -> {
     LOGGER.info("{}: {}", key, headers.get(key));
     });
}
}
