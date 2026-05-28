package com.henrique.projetopessoalback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ProjetoPessoalBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoPessoalBackApplication.class, args);
    }

}
