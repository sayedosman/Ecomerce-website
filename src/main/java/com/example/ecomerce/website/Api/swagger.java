package com.example.ecomerce.website.Api;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class swagger {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demojpa")).build()
				.apiInfo(apiInfo());
				
		
	}
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"App REST API",
				"This is the back end App APIS provide by springBoot",
				"API TOS",
				"Terms of service",
				new Contact("Sayed Osman","www.example.com","sayedothman46@gmail.com"),
				"License of API","API License URL",
				Collections.emptyList());
				
	}
	
}
