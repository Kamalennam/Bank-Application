package com.Bank_Application.Bank_Application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bank_Application.Bank_Application.entity.Account;
import com.Bank_Application.Bank_Application.entity.User;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findByAccountNumber(Long accountNumber);
	
	Optional<Account> findByUser(User user);

}
