package com.user.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.api.dto.HealthDTO;

@CrossOrigin(origins = "*")
@RestController
public class HealthController {

	@GetMapping("/health")
	public HealthDTO getHealth() 	
	{
		return new HealthDTO();
	}
	
}
