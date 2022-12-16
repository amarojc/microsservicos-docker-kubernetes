package com.amaro.microsservices.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.microsservices.dtos.ItemDTO;

//Classe dependente da classe Shop... 
@Embeddable
public class Item {
	
	@Column(name="product_identifier")
	private String productIdentifier;
	
	private Float price;
	
	public Item() {
	}
	
	public Item(String productIdentifier, Float price) {
		super();
		this.productIdentifier = productIdentifier;
		this.price = price;
	}

	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public static Item convert(ItemDTO itemDTO) {
		Item item = new Item();
		item.setPrice(itemDTO.getPrice());
		item.setProductIdentifier(itemDTO.getProductIdentifier());
		
		return item;
	}
}
