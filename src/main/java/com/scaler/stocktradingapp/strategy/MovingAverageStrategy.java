package com.scaler.stocktradingapp.strategy;

import org.springframework.stereotype.Component;

@Component
public class MovingAverageStrategy implements TradingStrategy {
    private final int period = 14; // Default period

    @Override
    public void executeStrategy(String stockSymbol) {
        System.out.println("Executing Moving Average Strategy for " + stockSymbol + " with period " + period);
        // Add logic to calculate moving average
    }
}