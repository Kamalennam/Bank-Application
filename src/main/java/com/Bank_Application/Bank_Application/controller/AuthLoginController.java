package com.Bank_Application.Bank_Application.controller;

import java.util.Optional;

import javax.security.auth.login.CredentialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Bank_Application.Bank_Application.dto.LoginRequestDto;
import com.Bank_Application.Bank_Application.dto.LoginResponseDto;
import com.Bank_Application.Bank_Application.entity.User;
import com.Bank_Application.Bank_Application.service.AuthenticationService;
import java.util.logging.Logger;

@RestController
@RequestMapping("/auth")

public class AuthLoginController {

    @Autowired
    private AuthenticationService authenticationService;
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        logger.info("LoginRequestDTO received: " + loginRequestDto);
        logger.info("LoginRequestDTO received: " + loginRequestDto);
        logger.info("Password: " + loginRequestDto.getPassword());
//        if(loginRequestDto.getPassword() == null) {
//        	loginRequestDto.setPassword("1122");
//        }
        try {
            // Delegate login handling to authenticationService
            LoginResponseDto response = authenticationService.login(loginRequestDto);

            logger.info("Login credentials: " + response);
         
            String token = response.getToken();
            logger.info("Generated token: " + token);
            
            if (token == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Token generation failed.");
            }

            return ResponseEntity.ok("Logged in successfully! Token: " + token);
            
        } catch (RuntimeException e) {
            logger.warning("Login failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
    

