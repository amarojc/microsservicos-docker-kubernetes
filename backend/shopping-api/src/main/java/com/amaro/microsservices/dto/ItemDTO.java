package com.amaro.microsservices.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.amaro.microsservices.entity.Item;

public class ItemDTO {

	@NotBlank
	private String productIdentifier;
	
	@NotNull
	private Float price;

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

	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setPrice(item.getPrice());
		itemDTO.setProductIdentifier(item.getProductIdentifier());
		
		return itemDTO; 
	}
}
