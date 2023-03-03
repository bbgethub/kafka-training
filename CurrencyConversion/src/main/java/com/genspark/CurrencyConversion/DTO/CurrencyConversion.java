package com.genspark.CurrencyConversion.DTO;

import com.genspark.CurrencyConversion.model.CurrencyExchange;
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
    public CurrencyConversion(CurrencyExchange currencyExchange){
        this.id=currencyExchange.getId();
       this.from=currencyExchange.getFrom();
        this.to=currencyExchange.getTo();
        this.conversionMultiple=currencyExchange.getConversionMultiple();
        this.port=currencyExchange.getPort();
    }
}
