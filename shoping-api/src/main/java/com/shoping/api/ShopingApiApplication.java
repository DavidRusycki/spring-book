package com.shoping.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ShopingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopingApiApplication.class, args);
	}

}
