package com.genspark.InfyBank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    int customerId;
    int accNo;
    String name;
    String address;
    String city;

}
