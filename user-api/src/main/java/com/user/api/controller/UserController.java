package com.user.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.api.dto.UserDTO;
import com.user.api.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users/{numeroPagina}")
	public List<UserDTO> getUsers(@PathVariable Integer numeroPagina) 
	{
		Pageable page = PageRequest.of(numeroPagina, 5);
		List<UserDTO> usuarios = userService.getAll(page);
		return usuarios;
	}

	@GetMapping("/user/{id}")
	UserDTO findById(@PathVariable Long id) 
	{
		return userService.findById(id);
	}

	@PostMapping("/user")
	UserDTO newUser(@RequestBody UserDTO userDTO) 
	{
		return userService.save(userDTO);
	}

	@GetMapping("/user/cpf/{cpf}")
	UserDTO findByCpf(@PathVariable String cpf) 
	{
		return userService.findByCpf(cpf);
	}

	@DeleteMapping("/user/{id}")
	UserDTO delete(@PathVariable Long id) 
	{
		return userService.delete(id);
	}

	@GetMapping("/user/search")
	public List<UserDTO> queryByName(@RequestParam(name = "nome", required = true) String nome) 
	{
		return userService.queryByName(nome);
	}
}