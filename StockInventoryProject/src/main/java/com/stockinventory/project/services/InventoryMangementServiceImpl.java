package com.stockinventory.project.services;

import org.springframework.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockinventory.project.dtos.LoginUserDto;
import com.stockinventory.project.model.Inventory;
import com.stockinventory.project.model.ResponseToken;
import com.stockinventory.project.model.Stock;
import com.stockinventory.project.model.User;
import com.stockinventory.project.repository.InventoryRepository;

@Service
public class InventoryMangementServiceImpl implements InventoryMangementService {

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final String REGISTRATION_URL = "http://localhost:8080/auth/signup";
	private static final String AUTHENTICATION_URL = "http://localhost:8080/auth/login";
	private static final String STOCK_URL = "http://localhost:8080/api/v1/stockname/";
	private static final String STOCK_UPDATE_URL = "http://localhost:8080/api/v1/stock/";

	@Override
	public Inventory saleStock(Inventory inventory) {
		Stock response = null;
		// create user registration object
		User registrationUser = getRegistrationUser();
		// convert the user registration object to JSON
		String registrationBody="";
		try {
			registrationBody = getBody(registrationUser);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// create headers specifying that it is JSON request
		HttpHeaders registrationHeaders = getHeaders();
		HttpEntity<String> registrationEntity = new HttpEntity<String>(registrationBody, registrationHeaders);

		try {
			// Register User
			ResponseEntity<String> registrationResponse = restTemplate.exchange(REGISTRATION_URL, HttpMethod.POST,
					registrationEntity, String.class);
			   // if the registration is successful		
			if (registrationResponse.getStatusCode().equals(HttpStatus.OK)) {

				// create user authentication object
				LoginUserDto authenticationUser = getAuthenticationUser();
				// convert the user authentication object to JSON
				String authenticationBody = getLoginBody(authenticationUser);
				// create headers specifying that it is JSON request
				HttpHeaders authenticationHeaders = getHeaders();
				HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody,
						authenticationHeaders);

				// Authenticate User and get JWT
				ResponseEntity<ResponseToken> authenticationResponse = restTemplate.exchange(AUTHENTICATION_URL,
						HttpMethod.POST, authenticationEntity, ResponseToken.class);
					
				// if the authentication is successful		
				if (authenticationResponse.getStatusCode().equals(HttpStatus.OK)) {
					String token = "Bearer " + authenticationResponse.getBody().getToken();
					HttpHeaders headers = getHeaders();
					headers.set("Authorization", token);
					HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
					// Use Token to get Response
					ResponseEntity<Stock> responseData = 
							restTemplate.exchange(STOCK_URL+inventory.getInventoryStockname(), HttpMethod.GET, jwtEntity, Stock.class);
					if (responseData.getStatusCode().equals(HttpStatus.OK)) {
						response = responseData.getBody();
					}
					response.setStockSize(response.getStockSize()+inventory.getInventorySaleStockCurrentsize());
					HttpEntity<Stock> jwtEntityUpdate = new HttpEntity<Stock>(response,headers);
					ResponseEntity<Stock> responseStockData = 
							restTemplate.exchange(STOCK_UPDATE_URL+response.getStockId(), HttpMethod.PUT, jwtEntityUpdate, Stock.class);
					Stock stockUpdate = responseStockData.getBody();
					System.out.println(responseStockData.getStatusCode()); // CREATED
					System.out.println(stockUpdate); 
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		Inventory inventoryNew=new Inventory();
		inventoryNew.setInventoryStockname(response.getStockName());
		inventoryNew.setInventorySaleStockPrevioussize(response.getStockSize());
		inventoryNew.setInventorySaleStockCurrentsize(response.getStockSize()+inventory.getInventorySaleStockCurrentsize());
		return inventoryRepository.save(inventoryNew);
	}
	
	private User getRegistrationUser() {
		User user = new User();
		user.setEmail("prangya@gmail.com");
		user.setPassword("prangya@123");
		user.setFullName("Prangya");
		return user;
	}

	private LoginUserDto getAuthenticationUser() {
		LoginUserDto logIn = new LoginUserDto();
		logIn.setEmail("prangya@gmail.com");
		logIn.setPassword("prangya@123");
		return logIn;
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}

	private String getBody(final User user) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(user);
	}
	
	private String getLoginBody(final LoginUserDto loginUser) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(loginUser);
	}

	@Override
	public Inventory orderStock(Inventory inventory) {
		Stock response = null;
		// create user registration object
		User registrationUser = getRegistrationUser();
		// convert the user registration object to JSON
		String registrationBody="";
		try {
			registrationBody = getBody(registrationUser);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// create headers specifying that it is JSON request
		HttpHeaders registrationHeaders = getHeaders();
		HttpEntity<String> registrationEntity = new HttpEntity<String>(registrationBody, registrationHeaders);

		try {
			// Register User
			ResponseEntity<String> registrationResponse = restTemplate.exchange(REGISTRATION_URL, HttpMethod.POST,
					registrationEntity, String.class);
			   // if the registration is successful		
			if (registrationResponse.getStatusCode().equals(HttpStatus.OK)) {

				// create user authentication object
				LoginUserDto authenticationUser = getAuthenticationUser();
				// convert the user authentication object to JSON
				String authenticationBody = getLoginBody(authenticationUser);
				// create headers specifying that it is JSON request
				HttpHeaders authenticationHeaders = getHeaders();
				HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody,
						authenticationHeaders);

				// Authenticate User and get JWT
				ResponseEntity<ResponseToken> authenticationResponse = restTemplate.exchange(AUTHENTICATION_URL,
						HttpMethod.POST, authenticationEntity, ResponseToken.class);
					
				// if the authentication is successful		
				if (authenticationResponse.getStatusCode().equals(HttpStatus.OK)) {
					String token = "Bearer " + authenticationResponse.getBody().getToken();
					HttpHeaders headers = getHeaders();
					headers.set("Authorization", token);
					HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
					// Use Token to get Response
					ResponseEntity<Stock> responseData = 
							restTemplate.exchange(STOCK_URL+inventory.getInventoryStockname(), HttpMethod.GET, jwtEntity, Stock.class);
					if (responseData.getStatusCode().equals(HttpStatus.OK)) {
						response = responseData.getBody();
					}
					response.setStockSize(response.getStockSize()-inventory.getInventoryOrderStockCurrentsize());
					HttpEntity<Stock> jwtEntityUpdate = new HttpEntity<Stock>(response,headers);
					ResponseEntity<Stock> responseStockData = 
							restTemplate.exchange(STOCK_UPDATE_URL+response.getStockId(), HttpMethod.PUT, jwtEntityUpdate, Stock.class);
					Stock stockUpdate = responseStockData.getBody();
					System.out.println(responseStockData.getStatusCode()); // CREATED
					System.out.println(stockUpdate); 
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		Inventory inventoryNew=new Inventory();
		inventoryNew.setInventoryStockname(response.getStockName());
		inventoryNew.setInventoryOrderStockPrevioussize(response.getStockSize());
		inventoryNew.setInventoryOrderStockCurrentsize(response.getStockSize()-inventory.getInventoryOrderStockCurrentsize());
		return inventoryRepository.save(inventoryNew);
	}

}
