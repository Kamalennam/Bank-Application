//package com.Bank_Application.Bank_Application.service;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////            .csrf().disable() // Disable CSRF protection if necessary
////            .authorizeHttpRequests(authorize -> authorize
////            	.requestMatchers("/users/username/**").permitAll()
////            	.requestMatchers("/users/id/**").permitAll()
////                .requestMatchers("/users/register").permitAll() // Allow unauthenticated access to /register
////                .anyRequest().authenticated() // Require authentication for other endpoints
////            )
////            .formLogin(); // or any other login mechanism
////
////        return http.build();
////    }
////
////	@Bean
////	public PasswordEncoder passwordEncoder() {
////		return new BCryptPasswordEncoder();
////	}
////	
////	 @Bean
////	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
////	        return authenticationConfiguration.getAuthenticationManager();
////	    }
//	
//	
//
//	    @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	        http
//	            .csrf().disable()
//	            .authorizeHttpRequests(authorize -> authorize
//	                .requestMatchers("/users/username/**").permitAll()
//	                .requestMatchers("/users/id/**").permitAll()
//	                .requestMatchers("/users/register").permitAll()
//	                .anyRequest().authenticated()
//	            )
//	            .formLogin(); // Configure form login if needed
//
//	        return http.build();
//	    }
//
//	    @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//	    @Bean
//	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//	        return authenticationConfiguration.getAuthenticationManager();
//	    
//	    }
//
//}

package com.Bank_Application.Bank_Application.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/users/username/**").permitAll()
                .requestMatchers("/users/id/**").permitAll()
                .requestMatchers("/auth/login").permitAll()
                .requestMatchers("/auth/ping").permitAll()
                .requestMatchers("/users/register").permitAll()
                .requestMatchers("/users/account").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin().disable(); // Configure form login if needed 

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

