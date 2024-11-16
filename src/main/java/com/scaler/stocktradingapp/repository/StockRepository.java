package com.scaler.stocktradingapp.repository;

import com.scaler.stocktradingapp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByTickerSymbol(String tickerSymbol);
}
