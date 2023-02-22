package com.genspark.KafkaProducerConsumerApp1.controller;

import com.genspark.KafkaProducerConsumerApp1.kafka.KafkaConsumer;
import com.genspark.KafkaProducerConsumerApp1.kafka.KafkaPublisher;
import com.genspark.KafkaProducerConsumerApp1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaProducerConsumerController {
    @Autowired
    KafkaPublisher kafkaPublisher;
    @Autowired
    KafkaConsumer kafkaConsumer;
    @PostMapping("/produce")
    public ResponseEntity produceMessage(@RequestBody User user)
    {
        kafkaPublisher.sendMessage(user);
        return ResponseEntity.ok("Message published to the topic");
    }
    @GetMapping("/consume")
    public ResponseEntity consumeMessage()
    {
        return ResponseEntity.ok(kafkaConsumer.getUserFromTopic());
    }
}
