package com.scaler.stocktradingapp.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategyFactory {
    private final MovingAverageStrategy movingAverageStrategy;
    private final BollingerBandsStrategy bollingerBandsStrategy;
    private final ExponentialMovingAverageStrategy exponentialMovingAverageStrategy;

    public StrategyFactory(MovingAverageStrategy ma, BollingerBandsStrategy bb, ExponentialMovingAverageStrategy ema) {
        this.movingAverageStrategy = ma;
        this.bollingerBandsStrategy = bb;
        this.exponentialMovingAverageStrategy = ema;
    }

    public TradingStrategy getStrategy(String strategyType) {
        switch (strategyType.toUpperCase()) {
            case "MOVING_AVERAGE":
                return movingAverageStrategy;
            case "BOLLINGER_BANDS":
                return bollingerBandsStrategy;
            case "EMA":
                return exponentialMovingAverageStrategy;
            default:
                throw new IllegalArgumentException("Invalid strategy type");
        }
    }
}