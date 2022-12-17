package com.amaro.microsservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amaro.microsservices.services.ShopService;

import br.com.microsservices.dtos.ShopDTO;

@RestController
@RequestMapping(value = "shopping")
public class ShopController {
	
	@Autowired
	private ShopService shopService;

	@PostMapping()
	public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO,
			@RequestHeader(name = "key" , required = true) String key ) {
		return shopService.save(shopDTO, key);				
	}
	
	@GetMapping("/shopsByUser/{userIdentifier}")
	public List<ShopDTO> getByShopsUser(@PathVariable String userIdentifier,
			@RequestHeader(name = "key", required = true) String key){
		return shopService.findAllByUserIdentifier(userIdentifier, key);
	}

	@GetMapping("/totalShopGreater")
	public List<ShopDTO> getByTotalShopGreaterThan(@RequestBody ShopDTO shopDTO){
		return shopService.findAllByTotalGreaterThan(shopDTO);
	}
	
	@GetMapping("/shopByDateGreaterThan")
	public List<ShopDTO> getByDateGreaterThan(@RequestBody ShopDTO shopDTO){
			return shopService.getByDateGreaterThanEqual(shopDTO);
	}
	
	@GetMapping("/shopByDateLessThan")
	public List<ShopDTO> getByDateLessThan(@RequestBody ShopDTO shopDTO){
		return shopService.getByDateLessThanEqual(shopDTO);
	}
	
	@GetMapping("/find30ShopsByDate")
	public List<ShopDTO> getTop30ByDateGreaterThan(@RequestBody ShopDTO shopDTO){
		return shopService.getTop30ByDateGreaterThanEqual(shopDTO);
	}
}
