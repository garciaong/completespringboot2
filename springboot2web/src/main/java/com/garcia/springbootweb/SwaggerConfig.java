package com.garcia.springbootweb;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * After the Docket bean is defined, its select() method returns an instance of
	 * ApiSelectorBuilder, which provides a way to control the endpoints exposed by
	 * Swagger.
	 * 
	 * Predicates for selection of RequestHandlers can be configured with the help
	 * of RequestHandlerSelectors and PathSelectors. Using any() for both will make
	 * documentation for your entire API available through Swagger.
	 * 
	 * To verify Springfox is working, access url
	 * http://localhost<port>/v2/api-docs
	 * 
	 * To view Swagger UI, access url http://localhost<por>/swagger-ui.html
	 */
	@Bean
	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build();
		/**
		 * This only expose controller in mentioned package with path /players as
		 * Swagger API documentation
		 */
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.garcia.springbootweb.controller"))
				.paths(PathSelectors.ant("/players")).build().apiInfo(apiInfo());

	}

	/**
	 * Swagger also provides some default values in its response which you can
	 * customize, such as “Api Documentation”, “Created by Contact Email”, “Apache
	 * 2.0”.
	 * 
	 * To change these values, you can use the apiInfo(ApiInfo apiInfo) method. The
	 * ApiInfo class that contains custom information about the API.
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo("SB2 REST API", "Springboot2 Swagger2 API", "API TOS", "Terms of service",
				new Contact("Garcia Ong", "www.garia.com", "info@garcia.com"), "License of API",
				"API license URL", Collections.emptyList());
	}

}
