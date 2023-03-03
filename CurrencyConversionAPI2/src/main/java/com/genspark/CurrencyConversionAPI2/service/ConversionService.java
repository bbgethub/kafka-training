package com.genspark.CurrencyConversionAPI2.service;

import com.genspark.CurrencyConversionAPI2.model.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConversionService {

    public CurrencyConversion convertCurrency(String from, String to, long quantity) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        String url="http://localhost:8000/api/currency-exchange/from/{from}/to/{to}";
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
                url, CurrencyConversion.class,
                uriVariables);
        CurrencyConversion response = responseEntity.getBody();
        double totalAmount=response.getConversionMultiple()*quantity;
        return new CurrencyConversion(response.getId(), from, to,  response.getPort(), response.getConversionMultiple(),quantity,
                totalAmount);
    }
}
