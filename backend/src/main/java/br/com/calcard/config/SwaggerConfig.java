package br.com.calcard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket detalheApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.com.calcard"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(informacoesApi().build());
		
		return docket;
	}
	
	private ApiInfoBuilder informacoesApi() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		Contact contact = new Contact(
								"Jeferson Job Ribeiro dos Santos", 
								"https://br.linkedin.com/in/jeferson-job-923027117", 
								"jeferson.job@outlook.com");
				
		apiInfoBuilder.title("API-Calcard");
		apiInfoBuilder.description("API para análise de crédito para aquisição do Cartão Calcard");
		apiInfoBuilder.version("0.0.1-SNAPSHOT");
		apiInfoBuilder.termsOfServiceUrl("Termos de serviço: Utilizado somente pela empresa Calcard");
		apiInfoBuilder.license("Calcard: Todos os direitos reservados");
		apiInfoBuilder.licenseUrl("https://github.com/calcardev/technical-evaluation");
		apiInfoBuilder.contact(contact);
		
		return apiInfoBuilder;
	}

}
