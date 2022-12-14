package com.product.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.ProductDTO;
import com.product.api.exception.ProductNotFoundException;
import com.product.api.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public List<ProductDTO> getProducts() 
	{
		List<ProductDTO> produtos = productService.getAll();
		return produtos;
	}

	@GetMapping("/product/category/{categoryId}")
	public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) 
	{
		List<ProductDTO> produtos = productService.getProductByCategoryId(categoryId);
		return produtos;
	}

	@GetMapping("/product/{productIdentifier}")
	ProductDTO findById(@PathVariable String productIdentifier) 
	{
		return productService.findByProductIdentifier(productIdentifier);
	}

	@PostMapping("/product")
	ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) 
	{
		return productService.save(productDTO);
	}

	@PutMapping("/product/update")
	ProductDTO updateProduct(@RequestBody ProductDTO productDTO) throws Exception 
	{
		ProductDTO user = productService.findById(productDTO.getId());
		if (user != null) {
			return productService.save(productDTO);			
		}
		throw new Exception("Esse produto não existe");
	}
	
	
	@DeleteMapping("/product/{id}")
	ProductDTO delete(@PathVariable Long id) throws ProductNotFoundException 
	{
		return productService.delete(id);
	}
}