package com.example.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.model.ExpenseModel;
import com.example.model.LoginModel;
import com.example.model.User;
import com.example.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AuthenticationService {

	public User register(UserModel user) throws JsonProcessingException;

	public HttpStatus login(LoginModel loginModel) throws JsonProcessingException;
	
	public List<ExpenseModel> getAllExpenses();

}
