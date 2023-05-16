package com.shopM.shopMen.config;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("shop").pathsToMatch("/shopM/**").build();
    }
/*
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("ShopMen").description(
                        "Your API description goes here").version("1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Your API documentation")
                        .url("https://your-api-documentation-url.com"));
    }*/
}
