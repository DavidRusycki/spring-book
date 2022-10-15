package com.product.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.api.dto.ProductDTO;
import com.product.api.entity.Product;
import com.product.api.exception.ProductNotFoundException;
import com.product.api.repository.ProductRepository;

@Service
public class ProductService 
{
	
	@Autowired
	private ProductRepository productRepository;

	public List<ProductDTO> getAll() 
	{
		List<Product> products = productRepository.findAll();
		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
	}

	public List<ProductDTO> getProductByCategoryId(Long categoryId) 
	{
		List<Product> products = productRepository.getProductByCategory(categoryId);
		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
	}

	public ProductDTO findByProductIdentifier(String productIdentifier) 
	{
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		if (product != null) 
		{
			return ProductDTO.convert(product);
		}
		return null;
	}

	public ProductDTO save(ProductDTO productDTO)
	{
		Product product = productRepository.save(Product.convert(productDTO));
		return ProductDTO.convert(product);
	}

	public ProductDTO delete(long productId) throws ProductNotFoundException 
	{
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) 
		{
			productRepository.delete(product.get());
		}
		
		return null;
	}
}
