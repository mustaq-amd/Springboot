package com.example.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.config.RestTemplateConfig;
import com.example.config.UrlProps;
import com.example.model.ExpenseModel;
import com.example.model.LoginModel;
import com.example.model.ResponseToken;
import com.example.model.User;
import com.example.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private RestTemplateService restTemplateService;

	@Autowired
	private RestTemplateConfig restTemplateConfig;

	@SuppressWarnings("unused")
	@Autowired
	private UrlProps urlProps;

	private HttpHeaders headers;

	@Override
	public HttpStatus login(LoginModel loginModel) {

		String authenticationBody = null;
		try {
			authenticationBody = restTemplateService.getBody(loginModel);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		headers = restTemplateService.getHeaders();

		HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody, headers);

		ResponseEntity<ResponseToken> authenticationResponse = restTemplateConfig.getRestTemplate()
				.exchange(UrlProps.AUTHENTICATION_URL, HttpMethod.POST, authenticationEntity, ResponseToken.class);

		if (authenticationResponse.getStatusCode().equals(HttpStatus.OK)) {

			String token = "Bearer " + authenticationResponse.getBody().getToken();

			headers.set("Authorization", token);

			System.out.println(loginModel.getUsername() + "  " + loginModel.getPassword());
			System.out.println("token : " + token);

			// HttpEntity<String> jwtEntity = new HttpEntity<String>(authenticationHeaders);

		}

		return authenticationResponse.getStatusCode();

	}

	@Override
	public User register(UserModel user) throws JsonProcessingException {

		headers = restTemplateService.getHeaders();

		String registrationBody = restTemplateService.getBody(user);
		HttpEntity<String> registrationEntity = new HttpEntity<String>(registrationBody, headers);

		ResponseEntity<String> registrationResponse = restTemplateConfig.getRestTemplate()
				.exchange(UrlProps.REGISTRATION_URL, HttpMethod.POST, registrationEntity, String.class);

		User newUser = new User();

		BeanUtils.copyProperties(user, newUser);

		return newUser;
	}

	@Override
	public List<ExpenseModel> getAllExpenses() {
		
		List<ExpenseModel> expenses = new ArrayList<>();

		ExpenseModel[] response = null;
		

		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		

		ResponseEntity<ExpenseModel[]> helloResponse = restTemplateConfig.getRestTemplate().exchange(UrlProps.EXPENSES_URL,
				HttpMethod.GET, jwtEntity, ExpenseModel[].class);
		
		

		if (helloResponse.getStatusCode().equals(HttpStatus.OK)) {
			response =helloResponse.getBody();
		}
		
		for(ExpenseModel expense : response) {
			expenses.add(expense);
		}

		return  expenses;

	}

}
