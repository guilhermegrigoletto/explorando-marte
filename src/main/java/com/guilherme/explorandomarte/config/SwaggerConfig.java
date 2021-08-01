package com.guilherme.explorandomarte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Explorando marte",
                "Teste tecnico de desenvolvedor da Elo7 em que um conjunto de sondas e enviada para Marte e deve permitir\n" +
                        "que elas sejam comandadas para explorar o local em uma malha retangular.",
                "1.0",
                "https://opensource.org/ToS",
                new Contact("Guilherme Grigoletto", "https://www.linkedin.com/in/guilherme-grigoletto/", "guilhermegfernandes@gmail.com"),
                "Free",
                "https://opensource.org/licenses/gpl-license",
                Collections.emptyList()
                );
        return apiInfo;
    }
}
