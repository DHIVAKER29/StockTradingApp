package com.scaler.stocktradingapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    private String stockSymbol;
    private int quantity;
    private double price;
    private LocalDateTime createdAt;

    @ManyToOne
    private TradingAccount tradingAccount;
}