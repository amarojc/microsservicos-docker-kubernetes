package com.amaro.microsservices.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.amaro.microsservices.dto.ItemDTO;

//Classe dependente da classe Shop... 
@Embeddable
public class Item {
	
	@Column(name="product_identifier")
	private String produtIdentifier;
	
	private Float price;
	
	public Item() {
	}
	
	public Item(String produtIdentifier, Float price) {
		super();
		this.produtIdentifier = produtIdentifier;
		this.price = price;
	}

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
	
	public static Item convert(ItemDTO itemDTO) {
		Item item = new Item();
		item.setPrice(itemDTO.getPrice());
		item.setProdutIdentifier(itemDTO.getProdutIdentifier());
		
		return item;
	}
}
