package com.genspark.service;

import com.genspark.model.WikimediaRecentChange;
import com.genspark.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    @Autowired
    WikimediaDataRepository wikimediaDataRepository;
    @KafkaListener(topics = "wikimedia_recentChange",groupId = "myGroup1")
    public void consumeDate(String eventMessage)
    {
        LOGGER.info(String.format("Consumed messages are -> %s",eventMessage));
        WikimediaRecentChange wikimediaRecentChange=new WikimediaRecentChange();
        wikimediaRecentChange.setWikiEventData(eventMessage);
        wikimediaDataRepository.save(wikimediaRecentChange);
    }

}
