package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.example.model.Animal;

public class CustomProducerSerializer implements Serializer<Animal> {
    private final ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public byte[] serialize(String topic, Animal animal) {
        try{
          if(animal==null)
          {
              System.out.println("animal Object is null, Can't serialize it");
              return null;
          }
            System.out.println("Serializing.....");
          return objectMapper.writeValueAsBytes(animal);
        }catch(Exception e){
            throw new SerializationException("Error when serializing Animal to byte array");
        }

    }
}
