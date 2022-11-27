package com.user.api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.user.api.dto.UserDTO;
import com.user.api.entity.User;
import com.user.api.repository.UserRepository;

@Service 
public class UserService
{

	@Autowired
	private	UserRepository userRepository;
	
	/**
	 * Retorna todos os usuários
	 * @return List<UserDTO>
	 */
	public List<UserDTO> getAll(Pageable page)
	{
		Page<User> usuarios = userRepository.findAll(page);
		return usuarios.stream().map(UserDTO::convert).collect(Collectors.toList());
	}
	
	/**
	 * Retorna todos os usuários
	 * @return List<UserDTO>
	 */
	public Integer getNumberPages(Pageable page)
	{
		Page<User> usuarios = userRepository.findAll(page);
		return usuarios.getTotalPages();
	}
	
	/**
	 * Retorna o usuário com o id
	 * @param userId
	 * @return UserDTO
	 */
	public UserDTO findById(long userId) 
	{
		Optional<User> usuario = userRepository.findById(userId);
		if (usuario.isPresent()) 
		{
			return UserDTO.convert(usuario.get());
		}
		
		return null;
	}
	
	/**
	 * Salva um usuário no banco de dados.
	 * @param userDTO
	 * @return UserDTO
	 */
	public UserDTO save(UserDTO userDTO)
	{
		userDTO.setDataCadastro(new Date());
		User user = userRepository.save(User.convert(userDTO));
		
		return UserDTO.convert(user);
	}
	
	/**
	 * Deleta um usuário do banco de dados
	 * @param userId
	 * @return UserDTO
	 */
	public UserDTO delete(long userId)
	{
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) 
		{
			userRepository.delete(user.get());
		}
		
		return null;
	}
	
	/**
	 * Retorna um usuário com base no CPF
	 * @param cpf
	 * @return UserDTO
	 */
	public UserDTO findByCpf(String cpf) 
	{
		User user = userRepository.findByCpf(cpf);
		if (user != null) 
		{
			return UserDTO.convert(user);
		}
		return null;
	}
	
	/**
	 * Retorna uma lista de usuário com base no nome.
	 * @param name
	 * @return List<UserDTO>
	 */
	public List<UserDTO> queryByName(String name)
	{
		List<User> usuarios = userRepository.queryByNomeLike(name);
		return usuarios.stream().map(UserDTO::convert).collect(Collectors.toList());
	}

}