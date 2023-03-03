package com.genspark.CurrencyConversionAPI2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyConversion {
    private int id;
    private String from;

    private String to;

    private int port;

    private float conversionMultiple;
    private long quantity;
    private double totalAmount;
}
