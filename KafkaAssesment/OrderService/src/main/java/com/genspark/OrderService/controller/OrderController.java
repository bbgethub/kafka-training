package com.genspark.OrderService.controller;

import com.genspark.MainProject.DTO.Order;
import com.genspark.MainProject.DTO.OrderEvent;
import com.genspark.OrderService.service.KafkaOrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    KafkaOrderProducer kafkaOrderProducer;
    @PostMapping("/create")
    public String placeOrder(@RequestBody Order order)
    {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setMessage("Order Status is pending");
        orderEvent.setStatus("PENDING");
        orderEvent.setOrder(order);
        kafkaOrderProducer.sendMessage(orderEvent);
        return "Order has placed successfully";
    }

}
