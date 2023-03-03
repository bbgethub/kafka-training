package com.genspark.CurrencyConversion.controller;

import com.genspark.CurrencyConversion.DTO.CurrencyConversion;
import com.genspark.CurrencyConversion.model.CurrencyExchange;
import com.genspark.CurrencyConversion.repository.CurrencyExchangeRepository;
import com.genspark.CurrencyConversion.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CurrencyExchangeController {
    @Autowired
    CurrencyExchangeService currencyExchangeService;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to){
        return currencyExchangeService.getCurrencyExchange(from,to);
    }
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConvert(@PathVariable String from,
                                                 @PathVariable String to,
                                                 @PathVariable String quantity){
        return currencyExchangeService.getCurrencyConvert(from,to,quantity);
    }
}
