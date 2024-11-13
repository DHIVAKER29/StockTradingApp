package com.scaler.stocktradingapp.service;

import com.scaler.stocktradingapp.model.Order;
import com.scaler.stocktradingapp.model.TradingAccount;
import com.scaler.stocktradingapp.observer.NotificationManager;
import com.scaler.stocktradingapp.proxy.StockExchangeProxy;
import com.scaler.stocktradingapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final StockExchangeProxy stockExchangeProxy;
    private final NotificationManager notificationManager;

    public OrderService(OrderRepository orderRepository, StockExchangeProxy stockExchangeProxy, NotificationManager notificationManager) {
        this.orderRepository = orderRepository;
        this.stockExchangeProxy = stockExchangeProxy;
        this.notificationManager = notificationManager;
    }

    public Order placeOrder(Order order, TradingAccount account) {
        // Validate account balance
        if (order.getOrderType().toString().equals("BUY") && account.getBalance() < order.getPrice() * order.getQuantity()) {
            throw new IllegalArgumentException("Insufficient balance for the order");
        }

        // Place order with the stock exchange
        stockExchangeProxy.placeOrder(order);

        // Save order to database
        Order savedOrder = orderRepository.save(order);

        // Notify user
        notificationManager.notifyAllObservers(account.getUser().getId(), "Order placed successfully: " + savedOrder.getOrderId());

        return savedOrder;
    }
}