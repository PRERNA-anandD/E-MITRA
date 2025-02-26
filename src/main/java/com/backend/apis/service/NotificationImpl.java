package com.backend.apis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.apis.dto.NotificationDto;
import com.backend.apis.model.Notification;
import com.backend.apis.repository.NotificationRepository;

@Service
public class NotificationImpl implements NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepo;
	
	@Override
	public Map<String, Object> addNotification(NotificationDto notificationDto) {
		
		Map<String, Object> response = new HashMap<>();
		
		Notification notification = new Notification();
		notification.setUserId(notificationDto.getUserId());
		notification.setTicketId(notificationDto.getTicketId());
		notification.setRead(false);
		
		notificationRepo.save(notification);
		
		response.put("success", true);
		response.put("id", notification.getId());
		response.put("message", "Notification Saved.");
		return response;
		
	}
	
	@Override
	public Map<String, Object> getNotifications(int userId) {
		
		Map<String, Object> response = new HashMap<>();
	
		List<Notification> notifications = notificationRepo.findByUserIdAndIsRead(userId, false);
	
		response.put("success", true);
		response.put("data", notifications);
		return response;
	}
	
	@Override
	public Map<String, Object> markReadNotifications(int userId) {
		
		Map<String, Object> response = new HashMap<>();
	
		List<Notification> notifications = notificationRepo.findByUserIdAndIsRead(userId, false);
		
		for (Notification notification : notifications) {
			notification.setRead(true);
			notificationRepo.save(notification);
		}
		response.put("success", true);
		response.put("count", notifications.size());
		return response;
	}

}
