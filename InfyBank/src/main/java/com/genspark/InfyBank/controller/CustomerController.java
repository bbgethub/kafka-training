package com.genspark.InfyBank.controller;

import com.genspark.InfyBank.entity.Customer;
import com.genspark.InfyBank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/customers")
    public List<Customer> getAllCustomerDetails()
    {
        return customerService.getAllCustomerDetails();
    }
    @GetMapping("/customers/{customerId}")
    public Optional<Customer> FindByCustomerId(@PathVariable("customerId") Integer customerId){
        return customerService.FindByCustomerId(customerId);
    }
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    @PutMapping("/customers/{customerId}")
    public Optional<Customer> UpdateByCustomerId(@PathVariable("customerId") Integer customerId,@RequestBody Customer customer){
        return customerService.UpdateByCustomerId(customerId,customer);
    }
    @DeleteMapping("/customers/{customerId}")
    public String DeleteByCustomerId(@PathVariable("customerId") Integer customerId){
        return customerService.DeleteByCustomerId(customerId);
    }
}
