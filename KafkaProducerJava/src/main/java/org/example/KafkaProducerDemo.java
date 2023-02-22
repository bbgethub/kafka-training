package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.Properties;

public class KafkaProducerDemo {
    private static final String TOPIC_NAME="AnimalTopic";
    public static void main(String args[])
    {
        KafkaProducer<String,String> kafkaProducer=null;
        try{
            String bootstrap_server="localhost:9092";
            //Create Producer Properties
            Properties properties=new Properties();
            properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrap_server);
            properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
           //Create the Producer
            kafkaProducer=new KafkaProducer<>(properties);
            ArrayList<String> animalList=getAnimalList();
            for(String animalName:animalList)
            {
                //Create Producer Record
                ProducerRecord<String,String> record=new ProducerRecord<String,String>(TOPIC_NAME,animalName);
                //Send Data
                kafkaProducer.send(record);
                System.out.println("Successfully sent animal name = "+animalName+"  to the Topic= "+TOPIC_NAME);
                Thread.sleep(4000);
            }
        }catch (Exception e)
        {
            System.out.println("Got Exception");
        }
        finally {
            if(kafkaProducer!=null)
            {
                kafkaProducer.flush();
                kafkaProducer.close();

            }
        }
    }
    private static ArrayList<String> getAnimalList(){
        ArrayList<String> animalList = new ArrayList<String>();
            animalList.add("Dog");
            animalList.add("Lion");
            animalList.add("Tiger");
            animalList.add("Snake");
            animalList.add("Cat");
            return animalList;
    }
}
