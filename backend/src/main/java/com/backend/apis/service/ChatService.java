package com.backend.apis.service;

import java.util.Map;

import com.backend.apis.dto.ChatDto;

public interface ChatService {
	
	Map<String, Object> storeChat(ChatDto chatDto);
	Map<String, Object> getChats(int senderId, int receiverId);

}
