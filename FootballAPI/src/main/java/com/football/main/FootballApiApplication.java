package com.football.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.football.controller.FootballController;

@SpringBootApplication
@ComponentScan(basePackageClasses = FootballController.class)
public class FootballApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballApiApplication.class, args);
	}

}
