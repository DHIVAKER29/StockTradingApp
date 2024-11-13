package com.scaler.stocktradingapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class TradingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private double balance;

    @ManyToOne
    private User user;

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}
