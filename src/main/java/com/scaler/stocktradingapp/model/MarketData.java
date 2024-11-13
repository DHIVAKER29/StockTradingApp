package com.scaler.stocktradingapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MarketData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private double currentPrice;
    private long volume;

    @ElementCollection
    private List<Double> historicalPrices;
}