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
		BigDecimal bg = new BigDecimal((Double) total).setScale(2, RoundingMode.HALF_EVEN);
		return bg.doubleValue();
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getMean() {
		BigDecimal bg = new BigDecimal((Double) mean).setScale(2, RoundingMode.HALF_EVEN);
		return bg.doubleValue();
	}

	public void setMean(Double mean) {
		this.mean = mean;
	}

}
