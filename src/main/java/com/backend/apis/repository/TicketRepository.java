package com.backend.apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.apis.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
	
	List<Ticket> findByCreatedBy(int createdBy);
	List<Ticket> findByAssignedTo(int assignedTo);
	List<Ticket> findByDepartment(String department);
	Ticket findById(int id);

}
