package br.com.treinaweb.ediaristas.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
//import static springfox.documentation.builders.RequestHandlerSelectors.any;
import java.util.Collections;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public Docket apiDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
                //.apiInfo(getApiInfo())
                //.useDefaultResponseMessages(false)
                //.consumes(Collections.singleton(MediaType.APPLICATION_JSON_VALUE))
                //.produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE));
    }

    /*private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Web API")
                .description("Projeto que permite fazer web chamadas")
                .version("1.0.0")
                .build();
    }*/
}
