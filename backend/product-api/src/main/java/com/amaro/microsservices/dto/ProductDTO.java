package com.amaro.microsservices.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.amaro.microsservices.entity.Product;

public class ProductDTO {

	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private Float preco;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String productIdentifier;
	
	@NotNull
	private CategoryDTO category;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	
	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public static ProductDTO convert(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		productDTO.setDescricao(product.getDescricao());
		productDTO.setProductIdentifier(product.getProductIdentifier());
		
		if(product.getCategory() != null) {
			productDTO.setCategory(CategoryDTO.convert(product.getCategory()));
		}
		
		return productDTO;
	}
	
}
