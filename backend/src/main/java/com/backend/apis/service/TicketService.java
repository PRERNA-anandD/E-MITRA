package com.backend.apis.service;

import java.util.Map;

import com.backend.apis.dto.TicketDto;

public interface TicketService {
	
	Map<String, Object> addTicket(TicketDto ticketDto);
	Map<String, Object> updateTicket(TicketDto ticketDto);
	Map<String, Object> getTickets();
	Map<String, Object> getCreatedByTickets(int createdBy);
	Map<String, Object> getAssignedToTickets(int assignedTo);
	Map<String, Object> getDepartmentTickets(String department);

}
