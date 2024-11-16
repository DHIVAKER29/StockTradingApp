package com.scaler.stocktradingapp.controller;

import com.scaler.stocktradingapp.dto.*;
import com.scaler.stocktradingapp.mapper.PortfolioMapper;
import com.scaler.stocktradingapp.model.*;
import com.scaler.stocktradingapp.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<PortfolioDTO> getPortfolio(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        Portfolio portfolio = portfolioService.getPortfolioByUser(user);
        return ResponseEntity.ok(PortfolioMapper.toDTO(portfolio)); // Assuming DTO mapper exists
    }

    @PostMapping("/{userId}/addStock")
    public ResponseEntity<Void> addStockToPortfolio(
            @PathVariable Long userId,
            @RequestParam Long stockId,
            @RequestParam int quantity) {
        User user = userService.getUserById(userId);
        portfolioService.addStockToPortfolio(user, stockId, quantity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{userId}/removeStock")
    public ResponseEntity<Void> removeStockFromPortfolio(
            @PathVariable Long userId,
            @RequestParam Long stockId) {
        User user = userService.getUserById(userId);
        portfolioService.removeStockFromPortfolio(user, stockId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
