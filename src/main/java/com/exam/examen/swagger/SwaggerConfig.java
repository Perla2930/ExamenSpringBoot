package com.exam.examen.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
    
    ApiInfo api_info() {
        return new ApiInfoBuilder()
            .title("Examen Spring Boot")
            .description("Servicios Rest Modulo Alumnos y Calificaciones")
            .license("/api/v1")
            .version("Version1")            
            .build();
    }
    
    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.exam.examen"))
                    .build().apiInfo(api_info());
    }
}