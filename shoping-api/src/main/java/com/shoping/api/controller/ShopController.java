package com.shoping.api.controller;

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

import com.shoping.api.dto.ShopDTO;
import com.shoping.api.service.ShopService;

@CrossOrigin(origins = "*")
@RestController
public class ShopController {
	
	@Autowired
	private ShopService shopService;

	@GetMapping("/shopping")
	public List<ShopDTO> getShops() {
		List<ShopDTO> produtos = shopService.getAll();
		return produtos;
	}

	@GetMapping("/shopping/shopByUser/{userIdentifier}")
	public List<ShopDTO> getShops(@PathVariable String userIdentifier) {
		List<ShopDTO> produtos = shopService.getByUser(userIdentifier);
		return produtos;
	}

	@GetMapping("/shopping/shopByDate")
	public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {
		List<ShopDTO> produtos = shopService.getByDate(shopDTO);
		return produtos;
	}

	@GetMapping("/shopping/{id}")
	public ShopDTO findById(@PathVariable Long id) {
		return shopService.findById(id);
	}

	@PutMapping("/shopping/update")
	ShopDTO updateShop(@RequestBody ShopDTO shopDTO) throws Exception 
	{
		ShopDTO shop = shopService.findById(shopDTO.getId());
		if (shop != null) {
			return shopService.save(shopDTO);			
		}
		throw new Exception("Essa venda/compra não existe");
	}
	
	@DeleteMapping("/shopping/{id}")
	public ShopDTO deleteShop(@PathVariable Long id) {
		return shopService.delete(id);
	}
	
	@PostMapping("/shopping")
	public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO) {
		return shopService.save(shopDTO);
	}
}
