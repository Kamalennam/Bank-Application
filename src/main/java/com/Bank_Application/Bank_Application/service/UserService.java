package com.Bank_Application.Bank_Application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Bank_Application.Bank_Application.entity.User;
import com.Bank_Application.Bank_Application.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private final UserRepository userRepository;
	@Autowired
    private final PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncode) {
    	this.userRepository=userRepository;
    	this.passwordEncoder=passwordEncode;
    }
    //User Registration
    public User userRegistration(User user) {
    	//Check if username or email is already taken or not...
		if(userRepository.findByUsername(user.getUsername()).isPresent() ||
				userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new IllegalStateException("Username or Email is already taken..!!");
		}
		//Encoding the password before saving...
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
    		String encodedPassword = passwordEncoder.encode(user.getPassword());
	        user.setPassword(encodedPassword);		
      return userRepository.save(user);

    }
    
    public Optional<User> findByUserId(Long id){
    	return userRepository.findById(id);
    }
    
    public Optional<User> findByUSerName(String username){
       return userRepository.findByUsername(username);
    }
    public Optional<User> findByEmail(String email){
    	return userRepository.findByEmail(email);
    }
}
