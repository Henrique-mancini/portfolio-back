package com.henrique.projetopessoalback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private static final String[] ALLOWED_METHODS = {"GET", "POST", "OPTIONS"};
    private static final String[] ALLOWED_HEADERS = {"Content-Type", "Accept", "Origin", "X-Requested-With"};
    private static final long MAX_AGE_SECONDS = 3600;

    private final AppProperties appProperties;

    public CorsConfig(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(appProperties.getCors().getAllowedOrigins().toArray(String[]::new))
                .allowedMethods(ALLOWED_METHODS)
                .allowedHeaders(ALLOWED_HEADERS)
                .maxAge(MAX_AGE_SECONDS);
    }

}
