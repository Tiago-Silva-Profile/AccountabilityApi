package com.ieadalpe.accountability.api.config_openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Accountability API",
        version = "v1",
        description = "Documentação da Accountability API"
))
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("user")
                .pathsToMatch("/api/user/**")  // Ajuste este caminho conforme necessário
                .pathsToExclude("/error/**")  // Exclui caminhos de erro
                .build();
    }
}


