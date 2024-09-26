package com.Bank_Application.Bank_Application.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Bank_Application.Bank_Application.controller.UserController;
import com.Bank_Application.Bank_Application.entity.Account;
import com.Bank_Application.Bank_Application.entity.User;
import com.Bank_Application.Bank_Application.repository.AccountRepository;


import jakarta.persistence.Id;

@Service
public class AccountService {
	
	
	@Autowired	
	private AccountRepository accountRepository;
	
	@Autowired
	private UserService userService;
	
	public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
	
	 private static final Logger logger = Logger.getLogger(UserController.class.getName());
	
//	public Account accountRegistration(Account account){
//		if(accountRepository.findBy_AccountNumber(account.getAccountNumber())  ) ){
//			){
//		}
//			
//		}
//		return account;
//		try {
//			if(accountRepository.findBy_AccountNumber(account.getAccountNumber())) {
//				throw new IllegalStateException("Account Number is already taken..!!");
//			}
//			String accountNumber = accountRepository.findBy_AccountNumber(account.getAccountNumber());
//			return account.getAccountNumber();
//		}catch(Exception e) {
//			
//		}
//		return account;
//	}
	
	public Account accountRegistration(Account account) {
		Optional<Account> existingAccount = accountRepository.findByAccountNumber(account.getAccountNumber());
		
		if(existingAccount.isPresent()) {
			logger.info("AccountNumber is already exists in db");
			throw new AccountAlreadyRegisteredException("Already Registered..!!" , HttpStatus.INTERNAL_SERVER_ERROR);
			
		}else {
			account.setCreatedDate(LocalDateTime.now());
			User user = userService.findByUserId(account.getUser().getUserId()).orElseThrow(()-> new RuntimeException("User is not found with the id: "+account.getUser().getUserId()));
//			User user = userService.findByUserId(id);
			logger.info("user details are : " + user);
			Optional<Account> IsAccountExisted = accountRepository.findByUser(user);
			if(IsAccountExisted.isPresent()) {
				throw new RuntimeException("User already has an account with these Details..!!");
			}
			account.setUser(user);
//			account.setStatus("Active");
			logger.info("AccountNumber is successfully registered  in db");
			return accountRepository.save(account);
		}
	}
	
	
}
