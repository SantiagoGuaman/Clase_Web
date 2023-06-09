package com.tec.azuay.edu.configuration.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenConfigApi {
	public class OpenApiConfig {
		
	    @Bean
	    OpenAPI usersMicroserviceOpenAPI() {
	        return new OpenAPI()
	                .info(new Info().title("Documentación de API REST")
	                                 .description("Documentación de la implementación de una API REST para "
	                                 		+ "back-end basada en MVC con el uso de Spring Boot en su versión 3.1.0")
	                                 .version("1.0"));
	    }
	}
}
