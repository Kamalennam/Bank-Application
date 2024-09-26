package com.Bank_Application.Bank_Application.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	 @Id	
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	 private Long userId;

	 @Column(name = "username", nullable = false, unique = true)
	 private String username;

	 @Column(name = "pass_word", nullable = false)
	 private String password;

	 @Column(name = "first_name", nullable = false)
	 private String firstName;

	 @Column(name = "last_name", nullable = false)
	 private String lastName;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "mobile_number", nullable = false)
	private String mobileNumber;

	@Column(name = "address", nullable = false)
	private String address;
	    
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@PrePersist
	protected void onCreate() {
	    createdAt = LocalDateTime.now();
	    updatedAt = LocalDateTime.now();
    }

    @PreUpdate
     protected void onUpdate() {
	        updatedAt = LocalDateTime.now();
	    }
		    
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long id) {
        this.userId = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
//    public String getRole() {
//        return role;
//    }
//    public void setRole(String role) {
//        this.role = role;
//    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
