package com.scaler.stocktradingapp.observer;

import com.scaler.stocktradingapp.model.NotificationStatus;
import com.scaler.stocktradingapp.model.UserNotification;
import com.scaler.stocktradingapp.repository.UserNotificationRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationManager {
    private final List<NotificationObserver> observers = new ArrayList<>();
    private final UserNotificationRepository userNotificationRepository;

    public NotificationManager(UserNotificationRepository repository) {
        this.userNotificationRepository = repository;
    }

    public void registerObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void unregisterObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(Long userId, String message) {
        for (NotificationObserver observer : observers) {
            observer.notifyUser(userId, message);
        }

        // Save notification in the database
        UserNotification notification = new UserNotification();
        notification.setUserId(userId);
        notification.setMessage(message);
        notification.setStatus(NotificationStatus.UNREAD);
        userNotificationRepository.save(notification);
    }
}