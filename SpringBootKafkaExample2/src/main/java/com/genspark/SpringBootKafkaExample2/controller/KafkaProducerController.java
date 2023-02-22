package com.genspark.SpringBootKafkaExample2.controller;
import com.genspark.SpringBootKafkaExample2.kafka.KafkaConsumer;
import com.genspark.SpringBootKafkaExample2.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private KafkaConsumer kafkaConsumer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        //return ResponseEntity.ok("Message sent to kafka topic");
        return ResponseEntity.ok(kafkaConsumer.consume(message));
    }
}
