package com.amaro.microsservices.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amaro.microsservices.services.ReportService;

import br.com.microsservices.dtos.ShopDTO;
import br.com.microsservices.dtos.ShopReportDTO;

@RestController
@RequestMapping(value = "shopping")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@GetMapping("/search")
	public List<ShopDTO> getShopByFilter(
				@RequestParam(name="dataInicio", required = true)
				@DateTimeFormat(pattern = "dd/MM/yyyy" ) Date dataInicio,
				@RequestParam(name="dataFim", required = false)
				@DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim,
				@RequestParam(name = "valorMinimo", required = false) Float valorMinimo){
	
		return reportService.getShopsByFilter(dataInicio, dataFim,  valorMinimo);
	}
	
	@GetMapping("/report")
	public ShopReportDTO getReportByDate(
			@RequestParam(name="dataInicio", required = true)
			@DateTimeFormat(pattern="dd/MM/yyyy") Date dataInicio,
			@RequestParam(name="dataFim", required = true)
			@DateTimeFormat(pattern ="dd/MM/yyyy") Date dataFim) {
	
		return reportService.getReportByDate(dataInicio, dataFim);
	}
}