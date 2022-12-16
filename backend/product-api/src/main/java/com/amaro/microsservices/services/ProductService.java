package com.amaro.microsservices.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaro.microsservices.converter.DTOConverter;
import com.amaro.microsservices.entity.Product;
import com.amaro.microsservices.repositories.CategoryRepository;
import com.amaro.microsservices.repositories.ProductRepository;

import br.com.microsservices.dtos.ProductDTO;
import br.com.microsservices.exception.CategoryNotFoundException;
import br.com.microsservices.exception.ProductNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	public ProductDTO save(ProductDTO productDTO) {
		//existsByiD, método do Spring Data... verificando se o id da category existe no banco.
		Boolean existsCategory = categoryRepository.existsById(productDTO.getCategory().getId());
		if(!existsCategory) {
			throw new CategoryNotFoundException();
		}
		productDTO.setId(null);
		Product product = productRepository.save(Product.convert(productDTO));
		return DTOConverter.convert(product);
	}

	public ProductDTO findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return DTOConverter.convert(product.get());
		}
		throw new ProductNotFoundException();
	}
	
	public ProductDTO findByProductIdentifier(String productIdentifier) {
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		if(product != null) {
			return DTOConverter.convert(product);
		}
		throw new ProductNotFoundException();
	}
	
	public List<ProductDTO> findAlll(){
		List<Product> products = productRepository.findAll();
		return products.stream().map(DTOConverter::convert).collect(Collectors.toList());
	}
	
	public List<ProductDTO> findAllProductsByCategoryId(Long id){
		List<Product> products = productRepository.findProductByCategory(id);
		return products.stream().map(DTOConverter::convert).collect(Collectors.toList());
	}
	
	public ProductDTO update(ProductDTO productDTO, String productIdentifier) {
		ProductDTO oldProductDTO = findByProductIdentifier(productIdentifier);
		productDTO.setId(oldProductDTO.getId());
		return DTOConverter.convert(productRepository.save(Product.convert(productDTO)));
	}
	
	public String delete(Long id) {
		ProductDTO productDTO = findById(id);
		String productIdentifier = productDTO.getNome() + " - ref: " + productDTO.getProductIdentifier();
		productRepository.delete(Product.convert(productDTO));
		return "Exclusão realizada: " + productIdentifier .toUpperCase(); 
	}
}
