package com.amaro.microsservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amaro.microsservices.dto.UserDTO;
import com.amaro.microsservices.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public UserDTO newUser(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
	@GetMapping("/users")
	public List<UserDTO> findAll(){
		return userService.findAll();
	}

	@GetMapping("/user/{id}")
	public UserDTO findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@GetMapping("/user/numCpf/{numCpf}")
	public UserDTO findByCpf(@PathVariable String numCpf) {
		return userService.findByCpf(numCpf);
	}
	
	@GetMapping("/user/search")
	public List<UserDTO> queryByName(@RequestParam(
						name = "nome", required = true) 
						String nome){
		return userService.queryByName(nome);
	}	
	
	@PutMapping("/user/{id}")
	public UserDTO update(@RequestBody UserDTO userDTO, @PathVariable Long id) {
		return userService.update(userDTO, id);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		return userService.delete(id);
	}
}
