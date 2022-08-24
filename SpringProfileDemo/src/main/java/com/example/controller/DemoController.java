package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Value("${message}")
	private String message;
	
	@GetMapping("/profile")
	public String getMessageSpecificToEnv() {
		return this.message;
	}

}
