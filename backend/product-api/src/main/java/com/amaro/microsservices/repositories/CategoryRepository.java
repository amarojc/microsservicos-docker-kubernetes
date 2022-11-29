package com.amaro.microsservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amaro.microsservices.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
