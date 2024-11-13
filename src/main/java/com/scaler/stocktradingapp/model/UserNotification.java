package com.scaler.stocktradingapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class UserNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    private String message;
    private Date timestamp;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    @ManyToOne
    private User user;
}