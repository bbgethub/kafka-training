package com.genspark.SpringBootKafkaExample2.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic testTopics() {
    return TopicBuilder.name("Example1") //Create a TopicBuilder with the supplied name.
    .build();
    }
}
