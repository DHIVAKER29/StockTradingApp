package com.scaler.stocktradingapp.repository;

import com.scaler.stocktradingapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStockSymbol(String stockSymbol);
}