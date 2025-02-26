package com.backend.apis.dto;

import com.backend.apis.model.TicketStatus;

public class TicketDto {
	private int id;
	private String subject;
	private String department;
	private String ticketBody;
	private int createdBy;
    private int assignedTo;
    private TicketStatus status;
	
	public TicketDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public TicketDto(int id, String subject, String department, String ticketBody, int createdBy, int assignedTo,
			TicketStatus status) {
		super();
		this.id = id;
		this.subject = subject;
		this.department = department;
		this.ticketBody = ticketBody;
		this.createdBy = createdBy;
		this.assignedTo = assignedTo;
		this.status = status;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTicketBody() {
		return ticketBody;
	}


	public void setTicketBody(String ticketBody) {
		this.ticketBody = ticketBody;
	}


	public int getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	public int getAssignedTo() {
		return assignedTo;
	}


	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}


	public TicketStatus getStatus() {
		return status;
	}


	public void setStatus(TicketStatus status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "TicketDto [id=" + id + ", subject=" + subject + ", department=" + department + ", ticketBody="
				+ ticketBody + ", createdBy=" + createdBy + ", assignedTo=" + assignedTo + ", status=" + status + "]";
	}
	
	
	
	
	
	

}
