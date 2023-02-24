package com.genspark.KafkaWikimediaProject.kafka;

import com.genspark.KafkaWikimediaProject.config.WikimediaEventHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class KafkaProducer {
    public static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String url) throws InterruptedException {
        EventHandler eventHandler=new WikimediaEventHandler(kafkaTemplate);
        EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource=builder.build();
        eventSource.start();
        Thread.sleep(10000);
        eventSource.close();
    }
}
