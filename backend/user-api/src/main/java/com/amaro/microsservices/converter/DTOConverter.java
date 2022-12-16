package com.amaro.microsservices.converter;

import com.amaro.microsservices.entity.User;

import br.com.microsservices.dtos.UserDTO;

public class DTOConverter {

	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setNome(user.getNome());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setCpf(user.getCpf());
		userDTO.setEmail(user.getEmail());
		userDTO.setTelefone(user.getTelefone());
		userDTO.setKey(user.getKey());
		userDTO.setDataCadastro(user.getDataCadastro());
		
		return userDTO;
	}
}