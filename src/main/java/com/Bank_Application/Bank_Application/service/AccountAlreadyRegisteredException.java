package com.Bank_Application.Bank_Application.service;

import org.springframework.http.HttpStatus;

public class AccountAlreadyRegisteredException extends RuntimeException {
	public  AccountAlreadyRegisteredException(String message, HttpStatus internalServerError) {
		super(message);
	}
}


