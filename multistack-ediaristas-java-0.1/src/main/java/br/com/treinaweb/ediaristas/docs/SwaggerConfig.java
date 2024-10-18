package br.com.treinaweb.ediaristas.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

//@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Claims Service", version = "1.0", description = "Claims Information"), security = {
//        @io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "bearerAuth")
//})
//@io.swagger.v3.oas.annotations.security.SecurityScheme(name = "bearerAuth", description = "JWT authentication", scheme = "bearer", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", in = SecuritySchemeIn.HEADER)

@Configuration
public class SwaggerConfig {

    String schemeName = "bearerAuth";
    String bearerFormat = "JWT";
    String scheme = "bearer";

    @Bean
    public OpenAPI caseOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(schemeName))
                .components(new Components()
                        .addSecuritySchemes(
                                schemeName, new SecurityScheme()
                                        .name(schemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .bearerFormat(bearerFormat)
                                        .in(SecurityScheme.In.HEADER)
                                        .scheme(scheme)))
                .info(new Info()
                        .title("Projeto API")
                        .description("Projeto API web")
                        .version("1.0.0"));
    }
}
