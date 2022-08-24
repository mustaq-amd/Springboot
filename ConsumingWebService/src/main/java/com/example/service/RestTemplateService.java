package com.example.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.example.model.LoginModel;
import com.example.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RestTemplateService {
	
	
	
	public HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}
	
	public String getBody(final LoginModel user) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(user);
	}
	
	public String getBody(final UserModel user) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(user);
	}
	
	

}
