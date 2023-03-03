package com.genspark.CurrencyConversionAPI2.controller;

import com.genspark.CurrencyConversionAPI2.model.CurrencyConversion;
import com.genspark.CurrencyConversionAPI2.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConversionController {
    @Autowired
    ConversionService conversionService;
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
                                              @PathVariable long quantity) {

     return conversionService.convertCurrency(from,to,quantity);
      //
    }
}
