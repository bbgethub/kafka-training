package com.genspark.KafkaExample3.Controller;

import com.genspark.KafkaExample3.Kafka.KafkaProducer;
import com.genspark.KafkaExample3.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KakfaProducerController {
@Autowired
private KafkaProducer kafkaProducer;
@PostMapping("/publish")
public ResponseEntity<String> publish(@RequestBody User user) {
kafkaProducer.sendMessage(user);
return ResponseEntity.ok("Message Sent to to Kafka topic");
}
}
