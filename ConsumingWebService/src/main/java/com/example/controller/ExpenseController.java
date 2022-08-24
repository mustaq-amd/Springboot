package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ExpenseModel;
import com.example.service.AuthenticationService;

@RestController
public class ExpenseController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@GetMapping("/expenses")
	public ResponseEntity<List<ExpenseModel>> getAllExpenses() {

		return new ResponseEntity<List<ExpenseModel>>(authenticationService.getAllExpenses(), HttpStatus.OK);
	}

}
