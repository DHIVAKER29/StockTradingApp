package com.scaler.stocktradingapp.strategy;

import org.springframework.stereotype.Component;

@Component
public class ExponentialMovingAverageStrategy implements TradingStrategy {
    private final int period = 10;

    @Override
    public void executeStrategy(String stockSymbol) {
        System.out.println("Executing Exponential Moving Average Strategy for " + stockSymbol);
        // Add logic to calculate EMA
    }
}