package com.amaro.microsservices.repositories;

import java.util.Date;
import java.util.List;

import com.amaro.microsservices.dto.ShopReportDTO;
import com.amaro.microsservices.entity.Shop;

public interface ReportRepository {

	public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);
	
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);

}