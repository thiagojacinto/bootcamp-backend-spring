package com.service.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				
				registry.addMapping("/v1/**")
					.allowedOrigins("http://localhost:4200")
					.allowedMethods("*");
				
				// to heroku allow connections from netlify
				registry.addMapping("/v1/**")
					.allowedOrigins("https://dot-store-angular.netlify.app/")
					.allowedMethods("*");
				
				registry.addMapping("/swagger-ui/**")
					.allowedOrigins("*");
				
				registry.addMapping("/api/v2/api-docs")
					.allowedOrigins("*");
				
			}
			
		};
	}
}
