package com.backend.apis.dto;

public class ResetPasswordDto {

	private String email;
	private String password;
	
	public ResetPasswordDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResetPasswordDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ResetPasswordDto [email=" + email + ", password=" + password + "]";
	}
	
	
	
}
