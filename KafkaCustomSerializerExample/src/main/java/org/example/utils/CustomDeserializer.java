package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.example.model.Animal;

public class CustomDeserializer implements Deserializer<Animal> {

 ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public Animal deserialize(String s, byte[] data) {
        try{
            if(data==null)
            {
                System.out.println("null value received");
                return null;
            }else{
                System.out.println("Deserializing....");
                return objectMapper.readValue(new String(data), Animal.class);
            }

        }catch(Exception e){
            throw new SerializationException("Error at Deserialization from byte array to animal object"+e);
        }


    }
}
