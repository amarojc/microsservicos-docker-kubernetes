package com.amaro.microsservices.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import br.com.microsservices.dtos.ShopDTO;

@Entity(name="shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_identifier")
	private String userIdentifier;
	private Float total;
	private Date date;

	//Eager -> Recuperando a coleção de itens junto com a entity principal Shop... 
	//Lazy -> Recupera somente quando for chamada
	@ElementCollection(fetch = FetchType.EAGER)
	//Definindo a tabela que contem os itens e a coluna join à tabela shop
	@CollectionTable(name = "item", 
				joinColumns = @JoinColumn(name = "shop_id"))
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
		/* Formatando o valor para ser exibido de forma mais eficaz, com apenas 2 casas decimais,
		    arredondo o valor mais próximo para cima/baixo, após retorno o valor para o tipo double formatado.
		*/
		BigDecimal bg = new BigDecimal((Float) total).setScale(2, RoundingMode.HALF_EVEN);
		
		return bg.floatValue();
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
	
	public static Shop convert(ShopDTO shopDTO) {
		Shop shop = new Shop();
		shop.setId(shopDTO.getId());
		shop.setUserIdentifier(shopDTO.getUserIdentifier());
		shop.setDate(shopDTO.getDate());
		shop.setTotal(shopDTO.getTotal());
		shop.setItens(
					  shopDTO.getItens().stream()
					  .map(Item::convert)
					  .collect(Collectors.toList())
					  );
		return shop;
		
	}

}
