package com.scaler.stocktradingapp.repository;

import com.scaler.stocktradingapp.model.TradingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradingAccountRepository extends JpaRepository<TradingAccount, Long> {
}