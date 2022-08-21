package com.springbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/health")
	public String getMensagem()
	{
		return "Spring Boot is Working!!!";
	}
	
}
