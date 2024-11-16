package com.scaler.stocktradingapp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tickerSymbol;
    private String name;
    private double currentPrice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    // Getters, setters, and constructors
}
