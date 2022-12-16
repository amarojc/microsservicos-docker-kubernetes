package com.amaro.microsservices.converter;

import java.util.stream.Collectors;

import com.amaro.microsservices.entity.Item;
import com.amaro.microsservices.entity.Shop;

import br.com.microsservices.dtos.ItemDTO;
import br.com.microsservices.dtos.ShopDTO;

public class DTOConverter {
	
	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setProductIdentifier(item.getProductIdentifier());
		itemDTO.setPrice(item.getPrice());
		return itemDTO;
	}

	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setId(shop.getId());
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		shopDTO.setDate(shop.getDate());
		shopDTO.setItens(shop.getItens().stream().map(DTOConverter::convert).collect(Collectors.toList()));
		
		return shopDTO;
	}
}