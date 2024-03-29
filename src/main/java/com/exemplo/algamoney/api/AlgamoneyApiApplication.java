package com.exemplo.algamoney.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.exemplo.algamoney.api.config.property.AlgamoneyApiProperty;

@SpringBootApplication
public class AlgamoneyApiApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AlgamoneyApiApplication.class, args);
	}

}
