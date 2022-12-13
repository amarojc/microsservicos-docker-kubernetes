package com.amaro.microsservices.converter;

import com.amaro.microsservices.dto.CategoryDTO;
import com.amaro.microsservices.dto.ProductDTO;
import com.amaro.microsservices.entity.Category;
import com.amaro.microsservices.entity.Product;

public class DTOConverter {

	public static CategoryDTO convert(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setNome(category.getNome());
		
		return categoryDTO;
	}
	
	public static ProductDTO convert(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		productDTO.setProductIdentifier(product.getProductIdentifier());
		if(productDTO.getCategory() != null) {
			productDTO.setCategory(
					DTOConverter.convert(product.getCategory()));
		}
		return productDTO;
	}
}