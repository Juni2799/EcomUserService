package com.example.EcomUserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EcomUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomUserServiceApplication.class, args);
	}

}
