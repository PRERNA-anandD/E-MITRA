package com.backend.apis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.apis.dto.ChatDto;
import com.backend.apis.model.Chat;
import com.backend.apis.repository.ChatRepository;

@Service
public class ChatImpl implements ChatService {
	
	@Autowired
	private ChatRepository chatRepo;
	
	@Override
	public Map<String, Object> storeChat(ChatDto chatDto) {
		
		Map<String, Object> response = new HashMap<>();
		
		Chat chat = new Chat();
		chat.setReceiverId(chatDto.getReceiverId());
		chat.setSenderId(chatDto.getSenderId());
		chat.setMessage(chatDto.getMessage());
		
		chatRepo.save(chat);
		
		response.put("success", true);
		response.put("id", chat.getId());
		response.put("message", "Chat Saved Succesfully.");
		return response;
		
	}
	
	@Override
	public Map<String, Object> getChats(int senderId, int receiverId) {
		
		Map<String, Object> response = new HashMap<>();
	
		List<Chat> chats = chatRepo.findAll();
	
		response.put("success", true);
		response.put("data", chats);
		return response;
	}

}
