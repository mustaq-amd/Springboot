package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.LoginModel;
import com.example.model.User;
import com.example.model.UserModel;
import com.example.service.AuthenticationService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class AuthController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody UserModel user) {

		ResponseEntity<User> userModel = null;

		try {
			userModel = new ResponseEntity<User>(authenticationService.register(user), HttpStatus.OK);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return userModel;
	}

	@PostMapping("/login")
	public ResponseEntity<HttpStatus> login(@RequestBody LoginModel loginModel) {

		try {
			authenticationService.login(loginModel);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}

	

}
