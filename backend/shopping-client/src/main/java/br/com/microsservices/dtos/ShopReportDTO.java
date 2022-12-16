package br.com.microsservices.dtos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShopReportDTO {

	private Integer count;
	private Double total;
	private Double mean;
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getTotal() {
		//Evitando error de JsonMappingException
		if(this.total != null) {
			BigDecimal bg = new BigDecimal((Double) total).setScale(2, RoundingMode.HALF_EVEN);
			return bg.doubleValue();
		}
		total = 0.;
		
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getMean() {
		if(this.mean != null) {
			BigDecimal bg = new BigDecimal((Double) mean).setScale(2, RoundingMode.HALF_EVEN);
			return bg.doubleValue();
		}
		mean =0.;
		return mean;
	}

	public void setMean(Double mean) {
		this.mean = mean;
	}

}
