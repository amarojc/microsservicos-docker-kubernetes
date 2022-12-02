package com.amaro.microsservices.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Shop {

	private Long id;
	private String userIdentifier;
	private Float total;
	private Date date;

	private List<Item> itens;

	public Shop() {

	}

	public Shop(Long id, String userIdentifier, Float total, Date date) {
		super();
		this.id = id;
		this.userIdentifier = userIdentifier;
		this.total = total;
		this.date = date;
	}

	public Shop(Long id, String userIdentifier, Float total, Date date, List<Item> itens) {
		super();
		this.id = id;
		this.userIdentifier = userIdentifier;
		this.total = total;
		this.date = date;
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Shop [id=");
		builder.append(id);
		builder.append(", userIdentifier=");
		builder.append(userIdentifier);
		builder.append(", total=");
		builder.append(total);
		builder.append(", date=");
		builder.append(date);
		builder.append(", itens=");
		builder.append(itens);
		builder.append("]");
		return builder.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
