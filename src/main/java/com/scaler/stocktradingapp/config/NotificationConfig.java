package com.scaler.stocktradingapp.config;

import com.scaler.stocktradingapp.observer.EmailNotification;
import com.scaler.stocktradingapp.observer.NotificationManager;
import com.scaler.stocktradingapp.observer.SMSNotification;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    public NotificationConfig(NotificationManager notificationManager, EmailNotification email, SMSNotification sms) {
        notificationManager.registerObserver(email);
        notificationManager.registerObserver(sms);
    }
}