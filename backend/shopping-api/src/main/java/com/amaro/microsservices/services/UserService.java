package com.amaro.microsservices.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.microsservices.dtos.UserDTO;
import br.com.microsservices.exception.UserNotFoundException;

@Service
public class UserService {
	
	@Value("${USER_API_URL:http://localhost:8080}")
	private String userApiUrl;
	
	//Comunicação com a user-api para buscar pelo cpf do usuário 
	public UserDTO getByUserCpfAndKey(String cpf, String key) {
		try {
			//RestTemplate atua de forma síncrona para executar solicitações HTTP...
			RestTemplate restTemplate = new RestTemplate();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(userApiUrl + "/user/cpf/" + cpf);
			builder.queryParam("key", key);
			System.out.println("URI: " + builder.toUriString());
			ResponseEntity<UserDTO> response = restTemplate.getForEntity(builder.toUriString(), UserDTO.class);
			
			return response.getBody();
		} catch (HttpClientErrorException e) {
			throw new UserNotFoundException();
		}
	}
}
