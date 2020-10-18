package com.service.ecommerce.config;

import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	
	@Bean
	Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(this.info())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(this.paths())
				.build();
	}
	
	private ApiInfo info() {
		return new ApiInfoBuilder()
				.title("Projeto Ecommerce")
				.description("Projeto final do módulo de Backend do Bootcamp UNIT.")
				.version("pre-alpha")
				.license("Mozilla Public License Version 2.0")
				.licenseUrl("https://github.com/thiagojacinto/bootcamp-backend-spring/blob/main/LICENSE")
				.contact(new Contact("Thiago Jacinto", "https://github.com/thiagojacinto", ""))
				.build();
	}
	
	private Predicate<String> paths() {
		return PathSelectors.regex("/v1.*");
//				.or(PathSelectors.regex("/*"));
	}

}
