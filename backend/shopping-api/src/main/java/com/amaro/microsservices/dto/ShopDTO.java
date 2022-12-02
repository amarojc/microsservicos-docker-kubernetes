package com.amaro.microsservices.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.amaro.microsservices.entity.Shop;

public class ShopDTO {

	private Long id;
	private String userIdentifier;
	private Float total;
	private Date date;

	private List<ItemDTO> itens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemDTO> itens) {
		this.itens = itens;
	}
	
	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setId(shop.getId());
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setDate(shop.getDate());
		shopDTO.setTotal(shop.getTotal());
		shopDTO.setItens(
						  shop.getItens().stream()
						  .map(ItemDTO::convert)
						  .collect(Collectors.toList())
						 );
		return shopDTO;
	}
}
