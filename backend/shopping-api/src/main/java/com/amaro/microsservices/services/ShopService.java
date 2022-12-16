package com.amaro.microsservices.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaro.microsservices.converter.DTOConverter;
import com.amaro.microsservices.entity.Shop;
import com.amaro.microsservices.repositories.ShopRepository;

import br.com.microsservices.dtos.ItemDTO;
import br.com.microsservices.dtos.ProductDTO;
import br.com.microsservices.dtos.ShopDTO;
import br.com.microsservices.dtos.UserDTO;

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	public ShopDTO save(ShopDTO shopDTO) {
		if(userService.getByUserCpf(shopDTO.getUserIdentifier()) == null) {
			return null;
		}
		
		validateProducts(shopDTO.getItens());
		
		shopDTO.setTotal(shopDTO
							.getItens()
							.stream()
							.map(x -> x.getPrice())
							.reduce((float) 0, Float::sum)
						);
		Shop shop = Shop.convert(shopDTO);
		shop.setDate(new Date());
		
		shop = shopRepository.save(shop);
		
		return DTOConverter.convert(shop);
	}
	
	public List<ShopDTO> findAllByUserIdentifier(String userIdentifier){
		UserDTO userDTO = userService.getByUserCpf(userIdentifier);
		if(userDTO != null) {
			List<Shop> shops = shopRepository.findAllByUserIdentifier(userDTO.getCpf());
			return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
		}
		return null;
	}
	
	public List<ShopDTO> getByDateGreaterThanEqual(ShopDTO shopDTO){
		List<Shop> shops = shopRepository.findAllByDateGreaterThanEqual(shopDTO.getDate());
		return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
	}
	
	public List<ShopDTO> getByDateLessThanEqual(ShopDTO shopDTO){
		List<Shop> shops = shopRepository.findAllByDateLessThanEqual(shopDTO.getDate());
		return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
	}
	
	public List<ShopDTO> getTop30ByDateGreaterThanEqual(ShopDTO shopDTO){
		List<Shop> shops = shopRepository.findTop30ByDateGreaterThanEqual(shopDTO.getDate());
		return  shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
	}
	
	public List<ShopDTO> findAllByTotalGreaterThan(ShopDTO shopDTO){
		List<Shop> shops = shopRepository.findAllByTotalGreaterThan(shopDTO.getTotal());
		return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());		
	}
	
	private boolean validateProducts(List<ItemDTO> itens) {
		for (ItemDTO item : itens) {
			ProductDTO prodDTO = productService.getProductByIdentifier(item.getProductIdentifier());
			if(prodDTO == null) {
				return false;
			}else {
				item.setPrice(prodDTO.getPreco());
			}
		}
		return true;
	}
	
}