package com.genspark.KafkaWikimediaProject.config;


import com.genspark.KafkaWikimediaProject.kafka.KafkaProducer;
import com.genspark.KafkaWikimediaProject.util.AppConstant;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
@AllArgsConstructor
public class WikimediaEventHandler implements EventHandler {
    public static final Logger LOGGER= LoggerFactory.getLogger(WikimediaEventHandler.class);
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("Loading Data -> %s ",messageEvent.getData()));
        kafkaTemplate.send(AppConstant.TOPIC_NAME,messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
