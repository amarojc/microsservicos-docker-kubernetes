package com.amaro.microsservices.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.microsservices.dtos.ProductDTO;
import br.com.microsservices.exception.ProductNotFoundException;

@Service
public class ProductService {
	
	@Value("${PRODUCT_API_URL:http://localhost:8081/product/}")
	private String productURL;
	
	public ProductDTO getProductByIdentifier(String productIdentifier) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = productURL + productIdentifier;
			ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
			
			return response.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new ProductNotFoundException();
		}
	}
}
