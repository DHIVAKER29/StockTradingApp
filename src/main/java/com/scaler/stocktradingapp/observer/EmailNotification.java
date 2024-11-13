package com.scaler.stocktradingapp.observer;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements NotificationObserver {

    @Override
    public void notifyUser(Long userId, String message) {
        System.out.println("Sending email to user " + userId + ": " + message);
        // Implement email sending logic here
    }
}