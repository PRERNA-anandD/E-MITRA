package com.backend.apis.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
    @Column(name="id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
	@Column(name = "email", length = 255)
	private String email;
	
    @Column(name = "name", length = 255)
    private String name;
    
    @Column(name = "password", length = 255)
    private String password;
    
    @Column(name = "address", length = 255)
    private String address;
    
    @Column(name = "mobile", length = 20)
    private String mobile;
 
    @Column(name = "department", length = 255)
    private String department;
 
    @Column(name = "role", length = 255)
    private String role;
    
    @Column(name = "reset_password")
    private boolean reset_password;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable=false, updatable= false)
    private Timestamp createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updateAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public boolean isReset_password() {
		return reset_password;
	}

	public void setReset_password(boolean reset_password) {
		this.reset_password = reset_password;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}
    
    
}
