package org.example;


import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.Properties;

public class KafkaProducerWithAckDemo {
    private static final String TOPIC_NAME="AnimalTopic";
    private static  String bootstrap_server="localhost:9092";
    public static void main(String args[])
    {
        KafkaProducer<String, String> kafkaProducer=null;

        try{
            //Create Producer Property
            Properties properties=new Properties();
            properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrap_server);
            properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
            //Create the Producer
            kafkaProducer=new KafkaProducer<String,String>(properties);
            ArrayList<String> animalList=getAnimalList();
            int i=0;
            for(String animalName:animalList)
            {
                i++;
                String key="Id_"+Integer.toString(i);
                String value=animalName;
                //Create Producer record
                ProducerRecord<String,String> producerRecord=new ProducerRecord<String,String>(TOPIC_NAME,key,value);
                System.out.println("Key: "+key+" Value: "+value);
                //Send data
                kafkaProducer.send(producerRecord, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        if(e==null)
                        {
                            System.out.println("Successfully received the details");
                            System.out.println("Topic: "+recordMetadata.topic()+" Partition: "+recordMetadata.partition()+"Offset: "+recordMetadata.offset()+" Timestamp: "+recordMetadata.timestamp());
                        }
                        else{
                            System.out.println("Can't Produce, getting error "+e.getMessage());
                        }
                    }
                }).get();//sending data forcefully
                System.out.println("Successfully sent animal name: "+value);
                Thread.sleep(5000);
            }
        }catch(Exception e){
            System.out.println("Got Exception");
    }finally {
            kafkaProducer.flush();
            kafkaProducer.close();
        }
    }
    private static ArrayList<String> getAnimalList(){
        ArrayList<String> animalList = new ArrayList<String>();
        animalList.add("Dog1");
        animalList.add("Lion1");
        animalList.add("Tiger1");
        animalList.add("Snake1");
        animalList.add("Cat1");
        return animalList;
    }
}
