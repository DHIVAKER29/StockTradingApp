package com.scaler.stocktradingapp.observer;

import org.springframework.stereotype.Component;

@Component
public class SMSNotification implements NotificationObserver {

    @Override
    public void notifyUser(Long userId, String message) {
        System.out.println("Sending SMS to user " + userId + ": " + message);
        // Implement SMS sending logic here
    }
}