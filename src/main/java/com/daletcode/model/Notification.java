package com.daletcode.model;

import com.daletcode.enumeration.NotificationChannel;
import com.daletcode.enumeration.NotificationType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_notification")
public class Notification {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    private String content;

    private NotificationType notificationType;

    private NotificationChannel notificationChannel;

    private boolean read;

    private Long UserId;

    private Long deviceId;
}
