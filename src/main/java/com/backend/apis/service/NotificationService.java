package com.backend.apis.service;

import java.util.Map;

import com.backend.apis.dto.NotificationDto;

public interface NotificationService {
	
	Map<String, Object> addNotification(NotificationDto notificationDto);
	Map<String, Object> getNotifications(int userId);
	Map<String, Object> markReadNotifications(int userId);
}
