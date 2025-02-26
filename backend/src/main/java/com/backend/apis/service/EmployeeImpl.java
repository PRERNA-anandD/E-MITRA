package com.backend.apis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.apis.dto.LoginDto;
import com.backend.apis.dto.RegisterDto;
import com.backend.apis.dto.ResetPasswordDto;
import com.backend.apis.model.Employee;
import com.backend.apis.repository.EmployeeRepository;
import com.backend.apis.utility.Utility;

@Service
public class EmployeeImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	private Utility utility = new Utility();

	@Override
	public Map<String, Object> addEmployee(RegisterDto registerDto) {

		Map<String, Object> response = new HashMap<>();

		Employee employee = new Employee();
		employee.setEmail(registerDto.getEmail());
		employee.setName(registerDto.getName());
		employee.setMobile(registerDto.getMobile());
		employee.setAddress(registerDto.getAddress());
		employee.setDepartment(registerDto.getDepartment());
		employee.setRole(registerDto.getRole());
		employee.setPassword(utility.generatePassword(registerDto.getName(), registerDto.getMobile()));
		employee.setReset_password(false);

		employeeRepo.save(employee);

		response.put("success", true);
		response.put("id", employee.getId());
		response.put("message", "Employee registered Succesfully.");
		return response;

	}

	@Override
	public Map<String, Object> loginEmployee(LoginDto loginDto) {

		Map<String, Object> response = new HashMap<>();

		Employee employee = employeeRepo.findByEmail(loginDto.getEmail());
		if (employee == null) {
			response.put("success", false);
			response.put("message", "Email not registered.");
			return response;
		}
		String db_password = employee.getPassword();
		if (db_password.equals(loginDto.getPassword())) {
			response.put("success", true);
			response.put("reset_password", employee.isReset_password());
			response.put("role", employee.getRole());
			response.put("id", employee.getId());
			response.put("name", employee.getName());
			response.put("department", employee.getDepartment());
			response.put("message", "Login Successfully.");
			return response;
		}

		response.put("success", false);
		response.put("message", "Email or password is incorrect.");
		return response;
	}

	@Override
	public Map<String, Object> resetEmployeePassword(ResetPasswordDto resetPasswordDto) {

		Map<String, Object> response = new HashMap<>();

		Employee employee = employeeRepo.findByEmail(resetPasswordDto.getEmail());
		if (employee == null) {
			response.put("success", false);
			response.put("message", "Email not registered.");
			return response;
		}

		employee.setPassword(resetPasswordDto.getPassword());
		employee.setReset_password(true);
		employeeRepo.save(employee);

		response.put("success", true);
		response.put("message", "Password reset Succesfully.");
		return response;
	}

	@Override
	public Map<String, Object> getEmployee() {

		Map<String, Object> response = new HashMap<>();

		List<Employee> employees = employeeRepo.findAll();

		response.put("success", true);
		response.put("data", employees);
		return response;
	}

	@Override
	public Map<String, Object> getDepartmentEngineers(String department) {

		Map<String, Object> response = new HashMap<>();

		List<Employee> employees = employeeRepo.findByDepartmentAndRole(department, "Engineer");

		response.put("success", true);
		response.put("data", employees);
		return response;
	}
	
	
	@Override
	public Employee getDepartmentTeamManager(String department) {

		List<Employee> employees = employeeRepo.findByDepartmentAndRole(department, "Team Manager");

		return employees.get(0);
	}
	
}
