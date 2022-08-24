package com.example.config;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
public class UrlProps {
	
	public static final String AUTHENTICATION_URL = "https://expense-manager-api-amdmustaq.herokuapp.com/api/v1/login";
	public static final String EXPENSES_URL = "https://expense-manager-api-amdmustaq.herokuapp.com/api/v1/expenses";
	public static final String REGISTRATION_URL = "https://expense-manager-api-amdmustaq.herokuapp.com/api/v1/register";
	

}
