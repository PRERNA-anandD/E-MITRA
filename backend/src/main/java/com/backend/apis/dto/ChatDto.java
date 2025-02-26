package com.backend.apis.dto;

public class ChatDto {
	
	private int id;
	private int senderId;
    private int receiverId;
    private String message;
    
	public ChatDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChatDto(int id, int senderId, int receiverId, String message) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.message = message;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ChatDto [id=" + id + ", senderId=" + senderId + ", receiverId=" + receiverId + ", message=" + message
				+ "]";
	}
    
    

}
