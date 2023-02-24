package com.genspark.KafkaWikimediaProject.config;

import com.genspark.KafkaWikimediaProject.util.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(AppConstant.TOPIC_NAME).build();
    }
}
