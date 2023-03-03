package com.genspark.CurrencyConversion.service;

import com.genspark.CurrencyConversion.DTO.CurrencyConversion;
import com.genspark.CurrencyConversion.model.CurrencyExchange;
import com.genspark.CurrencyConversion.repository.CurrencyExchangeRepository;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {
    @Autowired
    CurrencyExchangeRepository repository;
    CurrencyConversion currencyConversion;
    @Value("${server.port}")
    private String port;
    public CurrencyExchange getCurrencyExchange(String from,String to){
        CurrencyExchange currencyExchange=repository.findByFromAndTo(from,to);
        currencyExchange.setPort(Integer.parseInt(port));
        return currencyExchange;
    }

    public CurrencyConversion getCurrencyConvert(String from, String to, String quantity) {
        CurrencyExchange currencyExchange=repository.findByFromAndTo(from,to);
        currencyExchange.setPort(Integer.parseInt(port));
        currencyConversion=new CurrencyConversion(currencyExchange);
        currencyConversion.setQuantity(Long.parseLong(quantity));
        double totalAmount=currencyConversion.getConversionMultiple()*currencyConversion.getQuantity();
        currencyConversion.setTotalAmount(totalAmount);
        return currencyConversion;
    }
}
