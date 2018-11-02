package com.verizon.pra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class PolitrixRatingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolitrixRatingAppApplication.class, args);
	}
}
