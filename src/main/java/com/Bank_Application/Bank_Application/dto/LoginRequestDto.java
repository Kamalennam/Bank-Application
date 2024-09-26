package com.Bank_Application.Bank_Application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestDto {
	
	private String username;
	private String mobileNumber;
	@JsonProperty("password")
	 private String password;
	 
	 public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	 @Override
	    public String toString() {
	        return "LoginRequestDto{" +
	                "username='" + username + '\'' +
	                ", mobileNumber='" + mobileNumber + '\'' +
	                ", password='" + password + '\'' +
	                '}';
	    }
	
	

	 
	 
}
