package com.springbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookApplication.class, args);
	}

}
