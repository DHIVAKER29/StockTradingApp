package com.scaler.stocktradingapp.service;

import com.scaler.stocktradingapp.strategy.StrategyFactory;
import com.scaler.stocktradingapp.strategy.TradingStrategy;
import org.springframework.stereotype.Service;

@Service
public class TradingStrategyService {
    private final StrategyFactory strategyFactory;

    public TradingStrategyService(StrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    public void executeStrategy(String strategyType, String stockSymbol) {
        TradingStrategy strategy = strategyFactory.getStrategy(strategyType);
        strategy.executeStrategy(stockSymbol);
    }
}
