package com.scaler.stocktradingapp.service;

import com.scaler.stocktradingapp.model.UserNotification;
import com.scaler.stocktradingapp.repository.UserNotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final UserNotificationRepository userNotificationRepository;

    public NotificationService(UserNotificationRepository userNotificationRepository) {
        this.userNotificationRepository = userNotificationRepository;
    }

    public List<UserNotification> getUserNotifications(Long userId) {
        return userNotificationRepository.findByUserId(userId);
    }
}