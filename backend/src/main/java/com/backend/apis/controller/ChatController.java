package com.backend.apis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.apis.dto.ChatDto;
import com.backend.apis.model.Message;
import com.backend.apis.service.ChatService;


@RestController
@CrossOrigin
@RequestMapping("api/v1/chat")
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        System.out.println(message.toString());
        return message;
    }
    
    @Autowired
    private ChatService chatService;
 
    @PostMapping(path = "/store-chat")
    public ResponseEntity<Map<String, Object>> saveTicket(@RequestBody ChatDto chatDto)
    {
    	Map<String, Object> response = chatService.storeChat(chatDto);
    	    	
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping(path = "/get-chats")
    public ResponseEntity<Map<String, Object>> getChats(@RequestParam(required = true) int sender_id, 
			@RequestParam(required = true) int receiver_id)
    {
    	Map<String, Object>response = chatService.getChats(sender_id, receiver_id);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
}