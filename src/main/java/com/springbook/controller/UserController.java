package com.springbook.controller;

import java.math.BigInteger;
import java.sql.Timestamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/home")
	public String getMensagem()
	{
		return "Spring Boot ist Running"; 	
	}
	
}
