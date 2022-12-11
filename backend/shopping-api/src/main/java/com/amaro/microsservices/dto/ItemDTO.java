package com.amaro.microsservices.dto;

import com.amaro.microsservices.entity.Item;

public class ItemDTO {

	private String productIdentifier;
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
