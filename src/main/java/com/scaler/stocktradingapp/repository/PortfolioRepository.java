package com.scaler.stocktradingapp.repository;

import com.scaler.stocktradingapp.model.Portfolio;
import com.scaler.stocktradingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByUser(User user);
}

