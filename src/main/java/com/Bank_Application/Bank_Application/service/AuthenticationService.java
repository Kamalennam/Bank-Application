package com.Bank_Application.Bank_Application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Bank_Application.Bank_Application.JwtTokenProvider.JwtTokenProvider;
import com.Bank_Application.Bank_Application.dto.LoginRequestDto;
import com.Bank_Application.Bank_Application.dto.LoginResponseDto;
import com.Bank_Application.Bank_Application.entity.User;
import com.Bank_Application.Bank_Application.repository.UserRepository;

@Service
public class AuthenticationService {

    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepository;
    
    public LoginResponseDto login(LoginRequestDto loginRequest) {
        // Fetch user based on username and mobile number only
        Optional<User> userOptional = userRepository.findByUsernameAndMobileNumber(
            loginRequest.getUsername(), 
            loginRequest.getMobileNumber()
        );
        
        if (userOptional.isPresent()) {
            User userDetails = userOptional.get();
            // Match the raw password with the encoded password in the database
            if (passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
            	//...
                String token = tokenProvider.generateToken(userDetails.getUsername());
                return new LoginResponseDto(token, userDetails.getUsername());
            } else {
                throw new RuntimeException("Invalid Credentials");
            }
        }
        throw new RuntimeException("User Not Found");
    }

    public Optional<User> findByUsernameAndMobileNumber(String username, String mobileNumber, String password) {
        // Query by username and mobile number only (without password)
        return userRepository.findByUsernameAndMobileNumber(username, mobileNumber);
    }
}
