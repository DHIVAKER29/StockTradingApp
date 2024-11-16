package com.scaler.stocktradingapp.dto;

import java.util.Map;

public class PortfolioDTO {
    private Long id;
    private Long userId;
    private Map<String, Integer> stocks; // Ticker Symbol -> Quantity

    // Getters, setters, and constructors
}