package com.Bank_Application.Bank_Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.Bank_Application.Bank_Application.entity.User;
import com.Bank_Application.Bank_Application.service.UserService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {
	

	@Configuration
	public class CorsConfig implements WebMvcConfigurer {
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4200") // Allow requests from this origin
	                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow only specific methods
	                .allowCredentials(true) // Allow sending cookies
	                .maxAge(3600); // Max age of the preflight request in seconds
	    }
	}
	
	 private static final Logger logger = Logger.getLogger(UserController.class.getName());
	 @Autowired
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
	    try {
	    	 logger.info("Registering user Details: " + user);
	    	 logger.info("Registering user Details: " + user.getUserId());
	        logger.info("Registering user name: " + user.getUsername());
	        logger.info("Registering user password: " + user.getPassword());
	        logger.info("Registering user firstname: " + user.getFirstName());
	        logger.info("Registering user lastname: " + user.getLastName());
	        logger.info("Registering user email: " + user.getEmail());
	        logger.info("Registering user mblnumber: " + user.getMobileNumber());
	        logger.info("Registering user address: " + user.getAddress());
	       
	       if(user.getPassword() == null) {
	    	   user.setPassword("123");
	       }
	    	 logger.info("Registering user ID: " + user.getUserId());
//		        logger.info("Registering user name: " + user.getUsername());
		        logger.info("Registering user password: " + user.getPassword());
	        user.setCreatedAt(LocalDateTime.now());
	        user.setUpdatedAt(LocalDateTime.now());
	      
	        User savedRegisteredUser = userService.userRegistration(user);
	        
	        logger.info("User successfully registered with id: " + savedRegisteredUser.getUserId());
	        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);

	    } catch (Exception e) {
	        logger.severe("Error during user registration: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	
	@GetMapping("/id/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		logger.info("Received user id to fetch details of user with specific id: " + id);
		Optional<User> userId = userService.findByUserId(id);
		if(userId.isPresent()) {
			logger.info("User Available with this id: ");
			return ResponseEntity.ok(userId.get());
		}else {
			logger.info("User not found with this id: " + id);
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<User> getUserByName(@PathVariable String username) {
	    logger.info("Fetching user with username: " + username);
	    Optional<User> user = userService.findByUSerName(username); 
	    if (user.isPresent()) {
	        logger.info("User found with username: " + username);
	        return ResponseEntity.ok(user.get());
	    } else {
	        logger.info("User not found with username: " + username);
	        return ResponseEntity.notFound().build();
	    }
	}

	
	
}
