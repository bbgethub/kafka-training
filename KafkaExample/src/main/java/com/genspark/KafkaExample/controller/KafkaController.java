package com.genspark.KafkaExample.controller;

import com.genspark.KafkaExample.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-kafka/")
public class KafkaController {
    @Autowired
    KafkaSender kafkaSender;
    @GetMapping("/producer")
    public String producer(@RequestParam("message") String message){
        kafkaSender.send(message);
        return "message sent to the kafka topic test";

    }
}
