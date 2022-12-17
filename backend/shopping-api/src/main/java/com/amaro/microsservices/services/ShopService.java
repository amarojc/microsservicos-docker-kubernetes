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
import br.com.microsservices.exception.ShopNotFoundException;

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	public ShopDTO save(ShopDTO shopDTO, String key) {
		System.out.println("user: " + shopDTO.getUserIdentifier() + " - Key:" + key);
		userService.getByUserCpfAndKey(shopDTO.getUserIdentifier(), key);

		validateProducts(shopDTO.getItens());

		shopDTO.setTotal(shopDTO.getItens().stream().map(x -> x.getPrice()).reduce((float) 0, Float::sum));
		Shop shop = Shop.convert(shopDTO);
		shop.setDate(new Date());

		shop = shopRepository.save(shop);

		return DTOConverter.convert(shop);
	}

	public List<ShopDTO> findAllByUserIdentifier(String userIdentifier, String key) {
		UserDTO userDTO = userService.getByUserCpfAndKey(userIdentifier, key);
		List<Shop> shops = shopRepository.findAllByUserIdentifier(userDTO.getCpf());
		if(!shops.isEmpty()) {
			return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
		}
		throw new ShopNotFoundException();
	}

	public List<ShopDTO> getByDateGreaterThanEqual(ShopDTO shopDTO) {
		List<Shop> shops = shopRepository.findAllByDateGreaterThanEqual(shopDTO.getDate());
		if (!shops.isEmpty()) {
			return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
		}
		throw new ShopNotFoundException();
	}

	public List<ShopDTO> getByDateLessThanEqual(ShopDTO shopDTO) {
		List<Shop> shops = shopRepository.findAllByDateLessThanEqual(shopDTO.getDate());
		if (!shops.isEmpty()) {
			return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
		}
		throw new ShopNotFoundException();
	}

	public List<ShopDTO> getTop30ByDateGreaterThanEqual(ShopDTO shopDTO) {
		List<Shop> shops = shopRepository.findTop30ByDateGreaterThanEqual(shopDTO.getDate());
		if (!shops.isEmpty()) {
			return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
		}
		throw new ShopNotFoundException();
	}

	public List<ShopDTO> findAllByTotalGreaterThan(ShopDTO shopDTO) {
		List<Shop> shops = shopRepository.findAllByTotalGreaterThan(shopDTO.getTotal());
		if(!shops.isEmpty()) {
			return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
		}
		throw new ShopNotFoundException();
	}

	private boolean validateProducts(List<ItemDTO> itens) {
		for (ItemDTO item : itens) {
			ProductDTO prodDTO = productService.getProductByIdentifier(item.getProductIdentifier());
			if (prodDTO == null) {
				return false;
			} else {
				item.setPrice(prodDTO.getPreco());
			}
		}
		return true;
	}

}