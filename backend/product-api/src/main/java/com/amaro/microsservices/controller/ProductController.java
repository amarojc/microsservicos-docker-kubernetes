package com.amaro.microsservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amaro.microsservices.dto.ProductDTO;
import com.amaro.microsservices.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public ProductDTO newProduct(@RequestBody @Valid ProductDTO productDTO) {
		return productService.save(productDTO); 
	}
	
	@GetMapping("/product/cod/{id}")
	public ProductDTO findById(@PathVariable Long id) {
		return productService.findById(id);
	}
	
	@GetMapping("/product/{productIdentifier}")
	public ProductDTO findByProductIdentifier(@PathVariable String productIdentifier) {
		return productService.findByProductIdentifier(productIdentifier);
	}
	
	@GetMapping("products")
	public List<ProductDTO> findAll(){
		return productService.findAlll();
	}
	
	@GetMapping("products/category/{id}")
	public List<ProductDTO> findAllProductsByCategoryId(@PathVariable Long id){
		return productService.findAllProductsByCategoryId(id);
	}

	@PutMapping("/product/{productIdentifier}")
	public ProductDTO update(@RequestBody @Valid ProductDTO productDTO,
																@PathVariable String productIdentifier) {
		return productService.update(productDTO, productIdentifier);
	}

	@DeleteMapping("product/{id}")
	public String delete(@PathVariable Long id) {
		return productService.delete(id);
	}
	
}
