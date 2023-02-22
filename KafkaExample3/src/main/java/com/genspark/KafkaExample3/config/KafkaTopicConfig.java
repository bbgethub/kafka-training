package com.genspark.KafkaExample3.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic getTopic() {
        return TopicBuilder.name("test") //Create a TopicBuilder with the supplied name.
                            .build();
    }
}
