package com.amaro.microsservices.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.amaro.microsservices.entity.Shop;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ShopDTO {

	private Long id;
	
	@NotBlank
	private String userIdentifier;
	
	@NotNull
	private Float total;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull
	private Date date;

	@NotNull
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
