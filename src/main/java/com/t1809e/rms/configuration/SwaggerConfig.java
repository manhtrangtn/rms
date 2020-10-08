package com.t1809e.rms.configuration;

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

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(Boolean.TRUE).select()
				.apis(RequestHandlerSelectors.basePackage("com.t1809e.rms.controller")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("FINAL PROJECT API DOCUMENTATION", "REST description of API.", "V1.0", "Terms of service",
				new Contact("Group 4", "website", "gmail"),
				"License of API", "API license URL", Collections.emptyList());
	}
}