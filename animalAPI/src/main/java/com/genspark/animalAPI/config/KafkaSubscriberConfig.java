package com.genspark.animalAPI.config;

import com.genspark.animalAPI.model.Animal;
import com.genspark.animalAPI.util.AppConstants;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaSubscriberConfig {
    @Bean
    public ConsumerFactory<String,Object> consumerFactory(){
        Map map=new HashMap<String,Object>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        map.put(ConsumerConfig.GROUP_ID_CONFIG, AppConstants.GROUP_ID);
        map.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        return new DefaultKafkaConsumerFactory<>(map,new StringDeserializer(),new JsonDeserializer<>(Animal.class));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Animal> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,Animal> factory=new ConcurrentKafkaListenerContainerFactory<String,Animal>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
