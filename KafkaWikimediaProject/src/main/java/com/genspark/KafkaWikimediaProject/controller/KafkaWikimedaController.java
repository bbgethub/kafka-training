package com.genspark.KafkaWikimediaProject.controller;

import com.genspark.KafkaWikimediaProject.kafka.KafkaConsumer;
import com.genspark.KafkaWikimediaProject.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wiki")
public class KafkaWikimedaController {
    @Autowired
    KafkaProducer kafkaProducer;
    @Autowired
    KafkaConsumer kafkaConsumer;
    @PostMapping("/produce")
    public ResponseEntity produceMessage(@RequestBody String url) throws InterruptedException {
        kafkaProducer.sendMessage(url);
        return ResponseEntity.ok(kafkaConsumer.consume(url));
    }
}
