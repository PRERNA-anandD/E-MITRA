package com.backend.apis.dto;

public class NotificationDto {
	private int userId;
	private int ticketId;

	public NotificationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public NotificationDto(int userId, int ticketId) {
		super();
		this.userId = userId;
		this.ticketId = ticketId;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	public int getTicketId() {
		return ticketId;
	}


	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}


	@Override
	public String toString() {
		return "NotificationDto [userId=" + userId + ", ticketId=" + ticketId + "]";
	}
	
	

}
