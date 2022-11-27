package com.product.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.product.api.entity.Product;

public class ProductDTO 
{
	
	private Long id;
	@NotBlank
	private String productIdentifier;
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	@NotNull
	private Float preco;
	@NotNull
	private CategoryDTO category;

	public static ProductDTO convert(Product product) 
	{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		productDTO.setProductIdentifier(product.getProductIdentifier());
		productDTO.setDescricao(product.getDescricao());
		if (product.getCategory() != null) {
			productDTO.setCategoryDTO(CategoryDTO.convert(product.getCategory()));
		}
		return productDTO;
	}

	public String getProductIdentifier() 
	{
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) 
	{
		this.productIdentifier = productIdentifier;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getDescricao() 
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public Float getPreco()
	{
		return preco;
	}

	public void setPreco(Float preco) 
	{
		this.preco = preco;
	}

	public CategoryDTO getCategoryDTO() 
	{
		return category;
	}

	public void setCategoryDTO(CategoryDTO category) 
	{
		this.category = category;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}
	
	
}