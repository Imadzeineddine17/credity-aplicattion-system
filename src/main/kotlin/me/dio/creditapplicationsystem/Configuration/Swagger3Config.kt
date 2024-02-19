package me.dio.creditapplicationsystem.Configuration

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Swagger3Config {
    @Bean
    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("springCreditApplicatonSystem-public")
            .pathsToMatch("/api/customers/**", "/api/credits/**")
            .build()
    }
}