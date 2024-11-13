package com.scaler.stocktradingapp.repository;

import com.scaler.stocktradingapp.model.MarketData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketDataRepository extends JpaRepository<MarketData, Long> {
    Optional<MarketData> findBySymbol(String symbol);
}