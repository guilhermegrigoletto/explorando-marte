package com.guilherme.explorandomarte;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExplorandoMarteApplication {
	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Explorando marte")
						.description("Teste tecnico de desenvolvedor da Elo7 em que um conjunto de sondas e enviada para Marte e deve permitir \n"+
								"//                        que elas sejam comandadas para explorar o local em uma malha retangular.")
						.version("v1.0.0")
						.license(new License().name("Apache 2.0").url("http://springdoc.org"))
				.contact(new Contact().email("guilhermegfernandes@gmail.com").url("https://www.linkedin.com/in/guilherme-grigoletto/")));
	}

	public static void main(String[] args) {
		SpringApplication.run(ExplorandoMarteApplication.class, args);
	}

}
