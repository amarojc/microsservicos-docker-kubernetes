package com.amaro.microsservices.repositories;

import java.util.Date;
import java.util.List;

import com.amaro.microsservices.entity.Shop;

import br.com.microsservices.dtos.ShopReportDTO;

public interface ReportRepository {

	public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);
	
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);

}