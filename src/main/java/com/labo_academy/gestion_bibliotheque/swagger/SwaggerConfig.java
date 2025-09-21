package com.labo_academy.gestion_bibliotheque.swagger;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Gestion Bibliothèque API")
                .description("Documentation interactive de l'API securise avec JWT de gestion d'une bibliothèque")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Équipe Technique - Labo Academy (Dzukam Rodrigue, Pemboura Inona)")
                    .email("rodrigueyanickpro@gmail.com, inonapemboura@gmail.com"))
                .license(new License()
                    .name("Licence MIT")
                    .url("https://opensource.org/licenses/MIT"))
                )
                .servers(List.of(
                    new Server().url("http://localhost:8080").description("Environnement de développement"),
                    new Server().url("https://api.labo-academy.com").description("Environnement de production")
                ))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}
