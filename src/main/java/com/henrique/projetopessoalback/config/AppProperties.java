package com.henrique.projetopessoalback.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    @Valid
    @NotNull
    private final Cors cors = new Cors();

    @Valid
    @NotNull
    private final Certificates certificates = new Certificates();

    public Cors getCors() {
        return cors;
    }

    public Certificates getCertificates() {
        return certificates;
    }

    public static class Cors {

        private List<String> allowedOrigins = List.of("http://localhost:3000");

        public List<String> getAllowedOrigins() {
            return allowedOrigins;
        }

        public void setAllowedOrigins(List<String> allowedOrigins) {
            this.allowedOrigins = sanitizeList(allowedOrigins);
        }

    }

    public static class Certificates {

        private String storageDir = "";

        public String getStorageDir() {
            return storageDir;
        }

        public void setStorageDir(String storageDir) {
            this.storageDir = sanitizeText(storageDir);
        }

    }

    private static List<String> sanitizeList(List<String> values) {
        if (values == null) {
            return List.of();
        }

        return values.stream()
                .map(AppProperties::sanitizeText)
                .filter(value -> !value.isBlank())
                .toList();
    }

    private static String sanitizeText(String value) {
        return value == null ? "" : value.trim();
    }

}
