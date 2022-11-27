package com.amaro.microsservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amaro.microsservices.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByCpf(String cpf);
	
	User findByCpfAndKey(String cpf, String key);
	
	List<User> queryByNomeLike(String nome);
}
