package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseToken {

	
	@JsonProperty("jwtToken")
	private String token;


	
	
	
}
