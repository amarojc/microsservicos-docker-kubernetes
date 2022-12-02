package com.amaro.microsservices.entity;

//Classe dependente da classe Shop... 
public class Item {
	
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
	
}
