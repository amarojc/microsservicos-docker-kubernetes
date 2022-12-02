package com.amaro.microsservices.dto;

import com.amaro.microsservices.entity.Item;

public class ItemDTO {

	private String produtIdentifier;
	private Float price;

	public String getProdutIdentifier() {
		return produtIdentifier;
	}

	public void setProdutIdentifier(String produtIdentifier) {
		this.produtIdentifier = produtIdentifier;
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
		itemDTO.setProdutIdentifier(item.getProdutIdentifier());
		
		return itemDTO;
	}
}
