package com.gabrielmacedo.dslist.docs;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("DS List")
                    .version("1.0.0")
                    .description("API para consultar e manipular listas de jogos")
                    .license(new License()
                            .name("MIT")
                            .url("https://springdoc.org")
                    )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub")
                        .url("https://github.com/gabrielssmacedo/dslist-intensivao"))
                .tags(
                        Arrays.asList(
                                new Tag().name("Games").description("Gerenciador de games"),
                                new Tag().name("Games List").description("Gerenciador de lista de games")
                        )
                );
    }
}
