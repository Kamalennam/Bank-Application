package com.Bank_Application.Bank_Application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bank_Application.Bank_Application.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);

	Optional<User> findByUsernameAndMobileNumberAndPassword(String username, String mobileNumber, String password);


	Optional<User> findByUsername(String username);

	Optional<User> findByUsernameAndMobileNumber(String username, String mobileNumber);
}
