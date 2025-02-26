package com.backend.apis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.apis.dto.NotificationDto;
import com.backend.apis.service.NotificationService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/notification")
public class NotificationController {
	
	@Autowired
    private NotificationService notificationService;
 
    @PostMapping(path = "/save")
    public ResponseEntity<Map<String, Object>> saveNotification(@RequestBody NotificationDto notificationDto)
    {
    	Map<String, Object> response = notificationService.addNotification(notificationDto);
    	    	
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping(path = "/get-notifications")
    public ResponseEntity<Map<String, Object>> getNotification(@RequestParam(required = true) int user_id)
    {
    	Map<String, Object>response = notificationService.getNotifications(user_id);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping(path = "/mark-read")
    public ResponseEntity<Map<String, Object>> markReadNotification(@RequestBody NotificationDto notificationDto)
    {
    	Map<String, Object> response = notificationService.markReadNotifications(notificationDto.getUserId());
    	    	
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
