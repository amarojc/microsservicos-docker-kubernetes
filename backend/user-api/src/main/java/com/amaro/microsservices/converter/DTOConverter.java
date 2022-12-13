package com.amaro.microsservices.converter;

import com.amaro.microsservices.dto.UserDTO;
import com.amaro.microsservices.entity.User;

public class DTOConverter {

	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		user.setNome(userDTO.getNome());
		user.setEndereco(userDTO.getEndereco());
		user.setCpf(userDTO.getCpf());
		user.setEmail(userDTO.getEmail());
		user.setTelefone(userDTO.getTelefone());
		user.setKey(userDTO.getKey());
		user.setDataCadastro(userDTO.getDataCadastro());
		
		return userDTO;
	}
}