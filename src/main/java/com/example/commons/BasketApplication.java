package com.example.commons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan("com.example.commons")
@ComponentScan("com.example")
public class BasketApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasketApplication.class, args);
	}
}
