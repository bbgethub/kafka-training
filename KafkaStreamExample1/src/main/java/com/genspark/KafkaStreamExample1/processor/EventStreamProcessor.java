package com.genspark.KafkaStreamExample1.processor;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EventStreamProcessor {
    @Autowired
    private StreamsBuilder streamsBuilder;
    @PostConstruct
    public void StreamTopology(){
        KStream<String,String> kStream = streamsBuilder.stream("test1", Consumed.with(Serdes.String(),Serdes.String()));
        kStream.filter((k,v)->v.startsWith("he_"))
                .mapValues((k,v)-> v.toUpperCase())
                .peek((k,v)-> System.out.println("key is: "+ k+"value is: "+v))
                .to("test2", Produced.with(Serdes.String(),Serdes.String()));
    }}
