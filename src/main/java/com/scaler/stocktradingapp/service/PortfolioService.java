package com.scaler.stocktradingapp.service;

import com.scaler.stocktradingapp.exception.*;
import com.scaler.stocktradingapp.model.*;
import com.scaler.stocktradingapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private StockRepository stockRepository;

    public Portfolio getPortfolioByUser(User user) {
        return portfolioRepository.findByUser(user).stream().findFirst().orElseThrow(
                () -> new ResourceNotFoundException("Portfolio not found for user: " + user.getId())
        );
    }

    public void addStockToPortfolio(User user, Long stockId, int quantity) {
        Portfolio portfolio = getPortfolioByUser(user);
        Stock stock = stockRepository.findById(stockId).orElseThrow(
                () -> new ResourceNotFoundException("Stock not found with id: " + stockId)
        );
        portfolio.getStocks().add(stock);
        portfolio.getStockQuantities().put(stock.getId(), portfolio.getStockQuantities().getOrDefault(stock.getId(), 0) + quantity);
        portfolioRepository.save(portfolio);
    }

    public void removeStockFromPortfolio(User user, Long stockId) {
        Portfolio portfolio = getPortfolioByUser(user);
        portfolio.getStocks().removeIf(stock -> stock.getId().equals(stockId));
        portfolio.getStockQuantities().remove(stockId);
        portfolioRepository.save(portfolio);
    }
}
