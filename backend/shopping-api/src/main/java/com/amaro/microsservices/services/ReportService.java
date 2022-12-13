package com.amaro.microsservices.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaro.microsservices.converter.DTOConverter;
import com.amaro.microsservices.dto.ShopDTO;
import com.amaro.microsservices.dto.ShopReportDTO;
import com.amaro.microsservices.entity.Shop;
import com.amaro.microsservices.repositories.ReportRepositoryImpl;

@Service
public class ReportService {

	@Autowired
	private ReportRepositoryImpl reportRepositoryImpl;
	
	public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo){
		List<Shop> shops = reportRepositoryImpl.getShopByFilters(dataInicio, dataFim, valorMinimo);
		return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
	}
	
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
		return reportRepositoryImpl.getReportByDate(dataInicio, dataFim);
	}
}