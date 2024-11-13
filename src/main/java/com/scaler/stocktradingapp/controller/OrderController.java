package com.scaler.stocktradingapp.controller;

import com.scaler.stocktradingapp.dto.OrderDTO;
import com.scaler.stocktradingapp.model.Order;
import com.scaler.stocktradingapp.model.TradingAccount;
import com.scaler.stocktradingapp.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDTO orderDTO, @RequestParam TradingAccount account) {
        Order order = new Order();
        order.setStockSymbol(orderDTO.getStockSymbol());
        order.setQuantity(orderDTO.getQuantity());
        order.setPrice(orderDTO.getPrice());
        return ResponseEntity.ok(orderService.placeOrder(order, account));
    }
}