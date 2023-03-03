package com.genspark.CurrencyConversion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="currency_exchange")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "currency_from")
    private String from;
    @Column(name ="currency_to")
    private String to;
    @Column(name ="port")
    private int port;
    @Column(name ="conversion")
    private float conversionMultiple;


}
