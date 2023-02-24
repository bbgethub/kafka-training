package org.example;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerDemo {
    private static final String TOPIC_NAME="AnimalTopic";
    public static void main(String args[]) {
        String bootstrap_servers = "localhost:9092";
        String groupId = "group1";
        //Create Properties Object for consumer configuration
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_servers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        //Create Consumer
        KafkaConsumer<String,String> kafkaConsumer=new KafkaConsumer<String,String>(properties);
        //Subscribe Consumer to our Topic
        kafkaConsumer.subscribe(Arrays.asList(TOPIC_NAME));

        //Poll for new data
        try {
            while (true) {
                ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    System.out.println("Key: " + consumerRecord.key() + " Value: " + consumerRecord.value());
                    System.out.println("Partition: " + consumerRecord.partition() + " Offset: " + consumerRecord.offset());
                }
            }
        }catch (Exception e)
        {
            System.out.println("Got Exception");
        }finally {
            kafkaConsumer.close();
            System.out.println("Consumer is now gracefully closed");
        }
    }


}
