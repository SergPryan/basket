package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@EntityScan("com.example.commons")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OprosnikApplication {

	public static void main(String[] args) {
		SpringApplication.run(OprosnikApplication.class, args);
	}
}
