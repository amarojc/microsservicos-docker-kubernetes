package com.amaro.microsservices.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaro.microsservices.dto.UserDTO;
import com.amaro.microsservices.entity.User;
import com.amaro.microsservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDTO save(UserDTO userDTO) {
		userDTO.setId(null);
		userDTO.setDataCadastro(new Date());
		userDTO.setKey(UUID.randomUUID().toString());// Gera chave de acesso
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convert(user);
	}

	public List<UserDTO> findAll() {
		List<User> user = userRepository.findAll();
		return user.stream().map(UserDTO::convert).collect(Collectors.toList());
	}

	public UserDTO findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return UserDTO.convert(user.get());
	}

	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		return UserDTO.convert(user);
	}

	public UserDTO update(UserDTO userDTO, Long id) {
		userDTO.setId(id);
		UserDTO oldDTO = findById(userDTO.getId());
		if (oldDTO != null) {
			userDTO.setDataCadastro(oldDTO.getDataCadastro());
			userDTO.setKey(oldDTO.getKey());
			if (oldDTO.getKey() == null) {
				userDTO.setKey(UUID.randomUUID().toString());
			}
		}
		return UserDTO.convert(userRepository.save(User.convert(userDTO)));
	}
	
	public String delete(Long id) {
		UserDTO userDTO = findById(id);
		if(userDTO != null) {
			userRepository.delete(User.convert(userDTO));
			return "O Usuário, " + userDTO.getNome() + " foi excluido com sucesso!";
		}
		return null;
	}
}
