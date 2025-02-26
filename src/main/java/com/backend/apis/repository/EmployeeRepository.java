package com.backend.apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.backend.apis.model.Employee;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	Employee findByEmail(String email);
	List<Employee> findByDepartmentAndRole(String department, String role);

}
