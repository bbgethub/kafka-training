package com.genspark.animalAPI.controller;

import com.genspark.animalAPI.model.Animal;
import com.genspark.animalAPI.service.KafkaConsumerService;
import com.genspark.animalAPI.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/animal")
public class KafkaAnimalController {
    @Autowired
    KafkaProducerService kafkaProducerService;
    @Autowired
    KafkaConsumerService kafkaConsumerService;
    @PostMapping("/produce")
    public ResponseEntity produceMessage(@RequestBody Animal animal)
    {
        kafkaProducerService.sendMessage(animal);
        return ResponseEntity.ok("Message published to the topic");
    }
    @GetMapping("/consume")
    public ResponseEntity consumeMessage()
    {
        return ResponseEntity.ok(kafkaConsumerService.getAnimalFromTopic());
    }
}
