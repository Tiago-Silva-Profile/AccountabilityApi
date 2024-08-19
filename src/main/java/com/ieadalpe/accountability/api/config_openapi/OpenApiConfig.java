package com.ieadalpe.accountability.api.config_openapi;

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

public class OpenApiConfig {

    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.ieadalpe.accountability.api.controller"))

                .paths(PathSelectors.any())
                    .build()
                    .apiInfo(apiInfo());
        }

        private ApiInfo apiInfo() {
            return new ApiInfo(
                    "Minha API",
                    "Descrição da API",
                    "1.0",
                    "Terms of service",
                    new Contact("Tiago Silva", "tiagosilvaprofile.com.br", "tiagosilva.profile@gmail.com"),
                    "License of API",
                    "API license URL",
                    Collections.emptyList());
        }
    }
}
