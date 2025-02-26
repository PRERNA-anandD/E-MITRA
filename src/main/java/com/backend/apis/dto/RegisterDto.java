package com.backend.apis.dto;

public class RegisterDto {

	private String email;
	private String name;
	private String mobile;
	private String address;
	private String department;
	private String role;
	
	public RegisterDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterDto(String email, String name, String mobile, String address, String department, String role) {
		super();
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.department = department;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RegisterDto [email=" + email + ", name=" + name + ", mobile=" + mobile + ", address=" + address
				+ ", department=" + department + ", role=" + role + "]";
	}
	
	
}
