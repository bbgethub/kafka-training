package com.genspark.CurrencyConversion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.genspark.CurrencyConversion.model.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Integer> {
    CurrencyExchange findByFromAndTo(String from,String to);
}
