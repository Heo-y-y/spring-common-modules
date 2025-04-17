package com.heoyy.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("공통 Swagger API")
                        .version("1.0.0")
                        .description("Swagger 설정 모듈입니다."))
                .servers(List.of(
                        new Server().url("/").description("Default Server") // 서버 명시
                ));
    }
}
