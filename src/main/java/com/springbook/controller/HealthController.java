package com.springbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbook.dto.HealthDTO;

@RestController
public class HealthController {

	@GetMapping("/health")
	public HealthDTO getHealth() 	
	{
		return new HealthDTO();
	}
	
}
