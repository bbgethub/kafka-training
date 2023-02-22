package com.genspark.InfyBank.service;

import com.genspark.InfyBank.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {
    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private KafkaTemplate<String,Customer> kafkaTemplate;
    String kafkaTopic="customerData";
    public CustomerService(KafkaTemplate<String,Customer> kafkaTemplate)
    {
        this.kafkaTemplate=kafkaTemplate;
    }
    static List<Customer> customers= new ArrayList<Customer>();
    {
//        Customer customer1=new Customer(1,101,"John","22 ss Street","Powel");
//        Customer customer2=new Customer(2,102,"Alex","60 RR Street","Masan");
//        customers.add(customer1);
//        customers.add(customer2);
    }
    @KafkaListener(topics = "customerData")
    public List<Customer> getAllCustomerDetails() {

        return customers;
    }
    

    public Customer createCustomer(Customer customer) {
        customers.add(customer);
        LOGGER.info("Message sent -> %s",customer.toString());
        Message<Customer> message= MessageBuilder
                .withPayload(customer)
                .setHeader(KafkaHeaders.TOPIC,"customerData")
                .build();
        kafkaTemplate.send(kafkaTopic,customer);
        return customer;
    }

    public Optional<Customer> FindByCustomerId(Integer customerId) {
        Optional<Customer> customer=customers.stream().filter(c->c.getCustomerId()==customerId).findFirst();
        return customer;
    }

    public Optional<Customer> UpdateByCustomerId(Integer customerId,Customer customer) {
        Optional<Customer> customer1=customers.stream()
                .filter(c->c.getCustomerId()==customerId)
                .findFirst()
                .map(c->{c.setCustomerId(customer.getCustomerId());
                    c.setAccNo(customer.getAccNo());
                    c.setName(customer.getName());
                    c.setAddress(customer.getAddress());
                    c.setCity(customer.getCity());
                return c;});
                return customer1;
    }

    public String DeleteByCustomerId(Integer customerId) {
//        Optional<Customer> customer=customers.stream().filter(c->c.getCustomerId()==customerId).findFirst();
//        System.out.println(customer);
//        customers.remove(customer);
        customers.removeIf(c->c.getCustomerId()==customerId);
        return "Deleted Successfully";
    }
}
