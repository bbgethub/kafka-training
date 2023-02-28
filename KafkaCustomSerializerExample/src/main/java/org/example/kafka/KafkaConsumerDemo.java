package org.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.example.model.Animal;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerDemo {
    private static final String TOPIC_NAME="AnimalWithSerializer";
    private static final String GROUP_ID="group_s";
    private static final String BOOTSTRAP_SERVER="localhost:9092";
    private static KafkaConsumer<String, Animal> kafkaConsumer;
    public static void main(String args[]){
        try{
            Properties properties=new Properties();
            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVER);
            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.example.utils.CustomDeserializer");
            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,GROUP_ID);
            properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
            kafkaConsumer=new KafkaConsumer<String,Animal>(properties);
            kafkaConsumer.subscribe(Arrays.asList(TOPIC_NAME));
            while(true){
                ConsumerRecords<String,Animal> consumerRecords=kafkaConsumer.poll(Duration.ofMillis(100));
                //System.out.println("Consuming the data");
                for(ConsumerRecord<String,Animal> consumerRecord:consumerRecords){
                    System.out.println("Key : "+consumerRecord.key()+
                            "Value : "+consumerRecord.value());
                    System.out.println("Partition : "+consumerRecord.partition()+
                            " Offset : "+consumerRecord.offset());
                }
            }
        }catch(Exception e){
            System.out.println("Got Exception: "+e);
        }finally {
            if(kafkaConsumer!=null)
                kafkaConsumer.close();
        }

    }
}
