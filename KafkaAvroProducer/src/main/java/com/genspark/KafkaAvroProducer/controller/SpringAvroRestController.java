//package com.genspark.KafkaAvroProducer.controller;
//
//import com.genspark.KafkaAvroProducer.service.SpringAvroProducer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import com.genspark.KafkaAvroProducer.model.StockHistoryModel;
//import java.util.Random;
//@RestController
//public class SpringAvroRestController {
//    @Autowired
//    private SpringAvroProducer springAvroProducer;
//    @PostMapping(value = "/sendStockHistory")
//    public void sendStockHistory(@RequestBody StockHistoryModel model){
//
//    StockHistoryModel  stockHistory= StockHistory.newBuilder().build();
//    stockHistory.setStockName(model.getStockName());
//    stockHistory.setTradeType(model.getTradeType());
//    stockHistory.setPrice(model.getPrice());
//    stockHistory.setAmount(model.getAmount());
//    stockHistory.setTradeId(new Random(1000).nextInt());
//    stockHistory.setTradeMarket(model.getTradeMarket());
//    stockHistory.setTradeQuantity(model.getTradeQuantity());
//    springAvroProducer.send(stockHistory);
//}
//}
