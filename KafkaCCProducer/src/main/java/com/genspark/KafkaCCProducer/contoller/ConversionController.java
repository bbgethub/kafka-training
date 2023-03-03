package com.genspark.KafkaCCProducer.contoller;

import com.genspark.KafkaCCProducer.model.CurrencyConversion;
import com.genspark.KafkaCCProducer.service.KafkaCCProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConversionController {
    @Autowired
    KafkaCCProducerService kafkaCCProducerService;
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
                                              @PathVariable long quantity) {

        return kafkaCCProducerService.convertCurrency(from, to, quantity);
    }
}
