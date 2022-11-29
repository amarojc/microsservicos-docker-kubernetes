package com.amaro.microsservices.entity;

import java.io.Serializable;
import java.util.Objects;

import com.amaro.microsservices.dto.ProductDTO;


public class Product implements Serializable{

	
	private static final long serialVersionUID = 1L;
 
	private Long id;
	private String nome;
	private Float preco;
	private String descricao;
	private String productIdentifier;
	private Category category;
	
	public Product() {

	}

	public Product(Long id, String nome, Float preco, String descricao, String productIdentifier) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.productIdentifier = productIdentifier;
	}

	public Product(Long id, String nome, Float preco, String descricao, String productIdentifier, Category category) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.productIdentifier = productIdentifier;
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", preco=");
		builder.append(preco);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", productIdentifier=");
		builder.append(productIdentifier);
		builder.append("]");
		return builder.toString();
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public static Product convert(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setNome(productDTO.getNome());
		product.setPreco(productDTO.getPreco());
		product.setDescricao(productDTO.getDescricao());
		product.setProductIdentifier(productDTO.getProductIdentifier());
		
		if(product.getCategory() != null) {
			product.setCategory(Category.convert(productDTO.getCategoryDTO()));
		}
		
		return product;
	}

}
