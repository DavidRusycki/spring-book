package com.product.api.dto;

import javax.validation.constraints.NotNull;

import com.product.api.entity.Category;

public class CategoryDTO {

	@NotNull
	private Long id;
	private String nome;
	
	public static CategoryDTO convert(Category category) 
	{
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setNome(category.getNome());
		return categoryDTO;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	
	
}