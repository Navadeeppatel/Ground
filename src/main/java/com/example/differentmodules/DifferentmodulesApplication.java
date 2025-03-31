package com.example.differentmodules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class DifferentmodulesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DifferentmodulesApplication.class, args);
	}

}
