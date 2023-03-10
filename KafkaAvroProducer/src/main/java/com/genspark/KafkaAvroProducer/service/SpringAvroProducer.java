package com.genspark.KafkaAvroProducer.service;

import com.genspark.KafkaAvroProducer.model.StockHistoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class SpringAvroProducer {

    @Value("${avro.topic.name}")
    String topicName;
    @Autowired
    private KafkaTemplate<String, StockHistoryModel> kafkaTemplate;     public void send(StockHistoryModel stockHistoryModel){
        ListenableFuture<SendResult<String,StockHistoryModel>> future= (ListenableFuture<SendResult<String, StockHistoryModel>>) kafkaTemplate.send(topicName,String.valueOf(stockHistoryModel.getTradeId()),stockHistoryModel);
        future.addCallback(new ListenableFutureCallback<SendResult<String, StockHistoryModel>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Message failed to produce");
            }            @Override
            public void onSuccess(SendResult<String, StockHistoryModel> result) {
                System.out.println("Avro message successfully produced");
            }
        });     }
}
