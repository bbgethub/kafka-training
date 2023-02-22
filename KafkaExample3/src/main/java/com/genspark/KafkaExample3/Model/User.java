package com.genspark.KafkaExample3.Model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
