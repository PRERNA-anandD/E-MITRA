package com.backend.apis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.apis.dto.NotificationDto;
import com.backend.apis.dto.TicketDto;
import com.backend.apis.model.Employee;
import com.backend.apis.model.Ticket;
import com.backend.apis.model.TicketStatus;
import com.backend.apis.repository.TicketRepository;

@Service
public class TicketImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepo;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public Map<String, Object> addTicket(TicketDto ticketDto) {
		
		Map<String, Object> response = new HashMap<>();
		
		Ticket ticket = new Ticket();
		ticket.setSubject(ticketDto.getSubject());
		ticket.setDepartment(ticketDto.getDepartment());
		ticket.setTicketBody(ticketDto.getTicketBody());
		ticket.setCreatedBy(ticketDto.getCreatedBy());
		ticket.setStatus(TicketStatus.NEW);
		
		ticketRepo.save(ticket);
		
		sendNotification(ticket.getId(), ticket.getCreatedBy());
		Employee employee = employeeService.getDepartmentTeamManager(ticket.getDepartment());
		sendNotification(ticket.getId(), employee.getId());
		
		response.put("success", true);
		response.put("id", ticket.getId());
		response.put("message", "Ticket Saved Succesfully.");
		return response;
		
	}
	
	@Override
	public Map<String, Object> updateTicket(TicketDto ticketDto) {
		
		Map<String, Object> response = new HashMap<>();
		
		Ticket ticket = ticketRepo.findById(ticketDto.getId());
		if (ticketDto.getStatus() != null ) {
			ticket.setStatus(ticketDto.getStatus());
		}
		
		if (ticketDto.getAssignedTo() != 0) {
			ticket.setAssignedTo(ticketDto.getAssignedTo());
			ticket.setStatus(TicketStatus.OPEN);
		}
		
		ticketRepo.save(ticket);
		
		if (ticketDto.getStatus() != null ) {
			if (ticketDto.getStatus() == TicketStatus.SOLVED) {
				sendNotification(ticketDto.getId(), ticket.getCreatedBy());
			}
		}
		
		if (ticketDto.getAssignedTo() != 0) {
			sendNotification(ticketDto.getId(), ticketDto.getAssignedTo());
		}
		
		response.put("success", true);
		response.put("id", ticket.getId());
		response.put("message", "Ticket Updated Succesfully.");
		return response;
		
	}
	
	@Override
	public Map<String, Object> getTickets() {
		
		Map<String, Object> response = new HashMap<>();
	
		List<Ticket> tickets = ticketRepo.findAll();
	
		response.put("success", true);
		response.put("data", tickets);
		return response;
	}
	
	@Override
	public Map<String, Object> getCreatedByTickets(int createdBy) {
		
		Map<String, Object> response = new HashMap<>();
	
		List<Ticket> tickets = ticketRepo.findByCreatedBy(createdBy);
	
		response.put("success", true);
		response.put("data", tickets);
		return response;
	}
	
	@Override
	public Map<String, Object> getAssignedToTickets(int assignedTo) {
		
		Map<String, Object> response = new HashMap<>();
	
		List<Ticket> tickets = ticketRepo.findByAssignedTo(assignedTo);
	
		response.put("success", true);
		response.put("data", tickets);
		return response;
	}
	
	@Override
	public Map<String, Object> getDepartmentTickets(String department) {
		
		Map<String, Object> response = new HashMap<>();
	
		List<Ticket> tickets = ticketRepo.findByDepartment(department);
	
		response.put("success", true);
		response.put("data", tickets);
		return response;
	}
	
	public void sendNotification(int ticketId, int userId) {
		NotificationDto notificationDto = new NotificationDto();
		notificationDto.setTicketId(ticketId);
		notificationDto.setUserId(userId);
		
		notificationService.addNotification(notificationDto);
	}
	
	

}
