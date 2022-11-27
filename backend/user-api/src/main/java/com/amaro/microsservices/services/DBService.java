package com.amaro.microsservices.services;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.amaro.microsservices.entity.User;
import com.amaro.microsservices.repositories.UserRepository;

@Service
public class DBService {

	@Autowired
	private UserRepository userRepository;
	
	@Bean
	public void instanciaDB() {	
		if(userRepository.findAll().size() < 1) {
			User user1 = new User(null, "Pedro de Lara", "123", "Rua pl" , "pedro@mail.com", "1234-4321", UUID.randomUUID().toString(),  new Date());
			User user2 = new User(null, "Logan", "321", "Rua lg" , "logan@mail.com", "6543-9874", UUID.randomUUID().toString(),  new Date());
			User user3 = new User(null, "Raimundo Nonato", "654", "Rua rm" , "raimundo@mail.com", "8523-1478", UUID.randomUUID().toString(),  new Date());
			User user4 = new User(null, "Chaves", "456", "Rua ch" , "chaves@mail.com", "9635-2563", UUID.randomUUID().toString(),  new Date());
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
		}
	}
}
