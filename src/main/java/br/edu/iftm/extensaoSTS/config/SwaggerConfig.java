package br.edu.iftm.extensaoSTS.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("br.edu.iftm.extensaoSTS"))
				.paths(regex("/atividade.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		@SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
				"Atividade API REST", 
				"ATIVIDADE REST de cadastro de Atividade.", 
				"1.0",
				"Terms of Service",
				new Contact("Crispim", "https://www.crispimluiz.com.br", 
						"crispimluiz@live.com"),
				"Apache License Version 2.0", 
				"https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());

		return apiInfo;
	}

}
