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

import com.backend.apis.dto.TicketDto;
import com.backend.apis.service.TicketService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/ticket")
public class TicketController {
	
	@Autowired
    private TicketService ticketService;
 
    @PostMapping(path = "/save")
    public ResponseEntity<Map<String, Object>> saveTicket(@RequestBody TicketDto ticketDto)
    {
    	Map<String, Object> response = ticketService.addTicket(ticketDto);
    	    	
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping(path = "/update-ticket")
    public ResponseEntity<Map<String, Object>> updateTicket(@RequestBody TicketDto ticketDto)
    {
    	Map<String, Object> response = ticketService.updateTicket(ticketDto);
    	    	
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping(path = "/get-tickets")
    public ResponseEntity<Map<String, Object>> getTickets()
    {
    	Map<String, Object>response = ticketService.getTickets();
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping(path = "/get-created-by-tickets")
    public ResponseEntity<Map<String, Object>> getCreatedByTickets(@RequestParam(required = true) int created_by)
    {
    	Map<String, Object>response = ticketService.getCreatedByTickets(created_by);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping(path = "/get-assigned-to-tickets")
    public ResponseEntity<Map<String, Object>> getAssignedToTickets(@RequestParam(required = true) int assigned_to)
    {
    	Map<String, Object>response = ticketService.getAssignedToTickets(assigned_to);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping(path = "/get-department-tickets")
    public ResponseEntity<Map<String, Object>> getDepartmentTickets(@RequestParam(required = true) String department)
    {
    	Map<String, Object>response = ticketService.getDepartmentTickets(department);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    

}
