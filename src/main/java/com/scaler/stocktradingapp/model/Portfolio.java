package com.scaler.stocktradingapp.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "portfolio_stock",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_id")
    )
    private List<Stock> stocks = new ArrayList<>();

    @ElementCollection
    private Map<Long, Integer> stockQuantities = new HashMap<>(); // Stock ID -> Quantity

    // Getters, setters, and constructors
}
