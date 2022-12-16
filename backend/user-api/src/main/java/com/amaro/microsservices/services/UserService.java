package com.amaro.microsservices.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaro.microsservices.converter.DTOConverter;
import com.amaro.microsservices.entity.User;
import com.amaro.microsservices.repositories.UserRepository;

import br.com.microsservices.dtos.UserDTO;
import br.com.microsservices.exception.UserNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDTO save(UserDTO userDTO) {
		userDTO.setId(null);
		userDTO.setDataCadastro(new Date());
		userDTO.setKey(UUID.randomUUID().toString());// Gera chave de acesso
		User user = userRepository.save(User.convert(userDTO));
		return DTOConverter.convert(user);
	}

	public List<UserDTO> findAll() {
		List<User> user = userRepository.findAll();
		return user.stream().map(DTOConverter::convert).collect(Collectors.toList());
	}

	public UserDTO findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return DTOConverter.convert(user.get());
		}
		throw new UserNotFoundException();
	}

	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		if (user != null) {
			return DTOConverter.convert(user);
		}
		throw new UserNotFoundException();
	}

	public List<UserDTO> queryByName(String nome) {
		List<User> user = userRepository.queryByNomeLike(nome + "%");
		if(!user.isEmpty()) {
		return user.stream().map(DTOConverter::convert).collect(Collectors.toList());
		}
		throw new UserNotFoundException();
	}

	public UserDTO update(UserDTO userDTO, Long id) {
		userDTO.setId(id);
		UserDTO oldDTO = findById(userDTO.getId());
		userDTO.setDataCadastro(oldDTO.getDataCadastro());
		userDTO.setKey(oldDTO.getKey());
		if (oldDTO.getKey() == null) {
			userDTO.setKey(UUID.randomUUID().toString());
		}
		return DTOConverter.convert(userRepository.save(User.convert(userDTO)));
	}

	public String delete(Long id) {
		UserDTO userDTO = findById(id);
		userRepository.delete(User.convert(userDTO));
		return "O Usuário, " + userDTO.getNome() + " foi excluido com sucesso!";
	}
}
