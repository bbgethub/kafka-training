package com.genspark.KafkaCCProducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyConversion {
    private int id;
    private String from;

    private String to;

    private int port;

    private float conversionMultiple;
    private long quantity;
    private double totalAmount;
}
