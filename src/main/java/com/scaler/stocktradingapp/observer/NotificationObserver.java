package com.scaler.stocktradingapp.observer;

public interface NotificationObserver {
    void notifyUser(Long userId, String message);
}