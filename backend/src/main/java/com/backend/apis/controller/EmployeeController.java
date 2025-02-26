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

import com.backend.apis.dto.LoginDto;
import com.backend.apis.dto.RegisterDto;
import com.backend.apis.dto.ResetPasswordDto;
import com.backend.apis.service.EmployeeService;


@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {
 
    @Autowired
    private EmployeeService employeeService;
 
    @PostMapping(path = "/register")
    public ResponseEntity<Map<String, Object>> registerEmployee(@RequestBody RegisterDto registerDto)
    {
    	Map<String, Object> response = employeeService.addEmployee(registerDto);
    	    	
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, Object>> loginEmployee(@RequestBody LoginDto loginDto)
    {
    	Map<String, Object>response = employeeService.loginEmployee(loginDto);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping(path = "/reset-password")
    public ResponseEntity<Map<String, Object>> resetEmployeePassword(@RequestBody ResetPasswordDto resetPasswordDto)
    {
    	Map<String, Object>response = employeeService.resetEmployeePassword(resetPasswordDto);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping(path = "/get-employees")
    public ResponseEntity<Map<String, Object>> getEmployee()
    {
    	Map<String, Object>response = employeeService.getEmployee();
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping(path = "/get-department-engineers")
    public ResponseEntity<Map<String, Object>> getDepartmentEngineers(@RequestParam(required = true) String department)
    {
    	Map<String, Object>response = employeeService.getDepartmentEngineers(department);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


