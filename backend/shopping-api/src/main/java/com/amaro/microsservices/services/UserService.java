package com.amaro.microsservices.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.microsservices.dtos.UserDTO;
import br.com.microsservices.exception.UserNotFoundException;

@Service
public class UserService {
	
	@Value("${USER_API_URL:http://localhost:8080}")
	private String userApiUrl;
	
	//Comunicação com a user-api para buscar pelo cpf do usuário 
	public UserDTO getByUserCpf(String cpf) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = userApiUrl + "/user/numCpf/" + cpf;
			ResponseEntity<UserDTO> response = restTemplate.getForEntity(url,UserDTO.class);
			
			return response.getBody();
		} catch (HttpClientErrorException e) {
			throw new UserNotFoundException();
		}
	}
}
