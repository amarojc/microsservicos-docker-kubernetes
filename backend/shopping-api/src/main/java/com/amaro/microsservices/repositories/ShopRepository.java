package com.amaro.microsservices.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amaro.microsservices.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository{

	//Lista todas as compras de um determinado usuário.
	public List<Shop> findAllByUserIdentifier(String userIdentifier);
	
	//Lista todas as compras maiores que o valor no parametro.
	public List<Shop> findAllByTotalGreaterThan(Float total);
	
	//Lista todas as compras realizadas igual ou maior que a data informada	
	public List<Shop> findAllByDateGreaterThanEqual(Date date);
	
	//Lista todas as compras realizadas antes da data informada.
	public List<Shop> findAllByDateLessThanEqual(Date date);
	
	//Lista as últimas 30 compras a partir da data informada.
	public List<Shop> findTop30ByDateGreaterThanEqual(Date date);
	
}
