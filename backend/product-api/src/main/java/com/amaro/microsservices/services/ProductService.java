package com.amaro.microsservices.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaro.microsservices.dto.ProductDTO;
import com.amaro.microsservices.entity.Product;
import com.amaro.microsservices.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	
	public ProductDTO save(ProductDTO productDTO) {
		Product product = productRepository.save(Product.convert(productDTO));
		return ProductDTO.convert(product);
	}

	public ProductDTO findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return ProductDTO.convert(product.get());
	}
	
	public ProductDTO findByProductIdentifier(String productIdentifier) {
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		return ProductDTO.convert(product);
	}
	
	public List<ProductDTO> findAlll(){
		List<Product> products = productRepository.findAll();
		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
	}
	
	public List<ProductDTO> findAllProductsByCategoryId(Long id){
		List<Product> products = productRepository.findProductByCategory(id);
		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
	}
	
	public ProductDTO update(ProductDTO productDTO, String productIdentifier) {
		ProductDTO oldProductDTO = findByProductIdentifier(productIdentifier);
		productDTO.setId(oldProductDTO.getId());
		return ProductDTO.convert(productRepository.save(Product.convert(productDTO)));
	}
	
	public String delete(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			productRepository.delete(product.get());
			return "Produto excluido com sucesso!"; 
		}
		return "Produto não localizado!";
	}
}
