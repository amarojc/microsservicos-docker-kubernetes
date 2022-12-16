package com.amaro.microsservices.converter;

import br.com.microsservices.dtos.CategoryDTO;
import br.com.microsservices.dtos.ProductDTO;
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
		productDTO.setDescricao(product.getDescricao());
		productDTO.setProductIdentifier(product.getProductIdentifier());
		if(product.getCategory() != null) {
			productDTO.setCategory(
					DTOConverter.convert(product.getCategory()));
		}
		return productDTO;
	}
}