package com.scaler.stocktradingapp.mapper;

import com.scaler.stocktradingapp.dto.PortfolioDTO;
import com.scaler.stocktradingapp.model.*;

import java.util.Map;
import java.util.stream.Collectors;

public class PortfolioMapper {

    public static PortfolioDTO toDTO(Portfolio portfolio) {
        Map<String, Integer> stockMap = portfolio.getStocks().stream()
                .collect(Collectors.toMap(Stock::getTickerSymbol, stock -> portfolio.getStockQuantities().get(stock.getId())));
        return new PortfolioDTO(portfolio.getId(), portfolio.getUser().getId(), stockMap);
    }
}