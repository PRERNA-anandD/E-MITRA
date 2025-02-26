package com.backend.apis.service;

import java.util.Map;

import com.backend.apis.dto.LoginDto;
import com.backend.apis.dto.RegisterDto;
import com.backend.apis.dto.ResetPasswordDto;
import com.backend.apis.model.Employee;

public interface EmployeeService {
	
	Map<String, Object> addEmployee(RegisterDto registerDto);
	Map<String, Object> loginEmployee(LoginDto loginDto);
	Map<String, Object> resetEmployeePassword(ResetPasswordDto resetPasswordDto);
	Map<String, Object> getEmployee();
	Map<String, Object> getDepartmentEngineers(String department);
	Employee getDepartmentTeamManager(String department);
}
