package com.genspark.config;

import com.genspark.util.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public static NewTopic newTopic(){
        return TopicBuilder.name(AppConstants.TOPIC_NAME).build();
    }
}
