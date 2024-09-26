package com.Bank_Application.Bank_Application.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bank_Application.Bank_Application.entity.Account;
import com.Bank_Application.Bank_Application.service.AccountService;

@RestController
@RequestMapping("/users")
public class AccountController {
	
	
	@Autowired
	private AccountService accountService;
	
	
	 private static final Logger logger = Logger.getLogger(UserController.class.getName());
	
	 @PostMapping("/account")
	public ResponseEntity<String>  createAccount(@RequestBody Account account){
		  try {
			 Account savedAccount =  accountService.accountRegistration(account);
			 
			 logger.info("Account successfully registered with id: " + savedAccount.getAccountId());
			 return new ResponseEntity<>("Account Created..!!", HttpStatus.OK);
			  
		  }catch(Exception e) {
			  logger.severe("Error during user registration: " + e.getMessage());
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
		  }

	}
}
