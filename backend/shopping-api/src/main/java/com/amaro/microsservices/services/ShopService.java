package com.amaro.microsservices.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaro.microsservices.dto.ShopDTO;
import com.amaro.microsservices.entity.Shop;
import com.amaro.microsservices.repositories.ShopRepository;

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	public ShopDTO save(ShopDTO shopDTO) {
		shopDTO.setTotal(shopDTO
							.getItens()
							.stream()
							.map(x -> x.getPrice())
							.reduce((float) 0, Float::sum)
						);
		Shop shop = Shop.convert(shopDTO);
		shop.setDate(new Date());
		
		shop = shopRepository.save(shop);
		
		return ShopDTO.convert(shop);
	}
	
	public List<ShopDTO> findAllByUserIdentifier(String userIdentifier){
		List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
	}
	
	public List<ShopDTO> getByDateGreaterThanEqual(ShopDTO shopDTO){
		List<Shop> shops = shopRepository.findAllByDateGreaterThanEqual(shopDTO.getDate());
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
	}
	
	public List<ShopDTO> getByDateLessThanEqual(ShopDTO shopDTO){
		List<Shop> shops = shopRepository.findAllByDateLessThanEqual(shopDTO.getDate());
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
	}
	
	public List<ShopDTO> getTop30ByDateGreaterThanEqual(ShopDTO shopDTO){
		List<Shop> shops = shopRepository.findTop30ByDateGreaterThanEqual(shopDTO.getDate());
		return  shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
	}
	
	public List<ShopDTO> findAllByTotalGreaterThan(ShopDTO shopDTO){
		List<Shop> shops = shopRepository.findAllByTotalGreaterThan(shopDTO.getTotal());
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());		
	}
}
