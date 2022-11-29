package com.amaro.microsservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amaro.microsservices.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "select p "
			+ "from product p "
			+ "join category c on p.category.id = c.id "
			+ "where c.id = :categoryId")
	public List<Product> findProductByCategory(@Param("categoryId") long categoryId);
	
	public Product findByProductIdentifier(String productIdentifier);
	
}


