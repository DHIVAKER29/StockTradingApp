package com.scaler.stocktradingapp.proxy;

import com.scaler.stocktradingapp.model.MarketData;
import com.scaler.stocktradingapp.model.Order;
import org.springframework.stereotype.Component;

@Component
public class StockExchangeProxy {
    public void placeOrder(Order order) {
        System.out.println("Order placed: " + order.getOrderId());
    }

    public MarketData fetchMarketData(String symbol) {
        System.out.println("Fetching market data for symbol: " + symbol);
        return new MarketData();
    }
}