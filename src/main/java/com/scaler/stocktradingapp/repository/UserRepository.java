package com.scaler.stocktradingapp.repository;

import com.scaler.stocktradingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}