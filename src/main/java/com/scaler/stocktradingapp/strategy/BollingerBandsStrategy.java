package com.scaler.stocktradingapp.strategy;

import org.springframework.stereotype.Component;

@Component
public class BollingerBandsStrategy implements TradingStrategy {
    private final int period = 20;
    private final double standardDeviation = 2.0;

    @Override
    public void executeStrategy(String stockSymbol) {
        System.out.println("Executing Bollinger Bands Strategy for " + stockSymbol);
        // Add logic to calculate Bollinger Bands
    }
}