package ru.lid.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import ru.lid.security.config.properties.JwtProperties;


@SpringBootApplication
//@EnableConfigurationProperties(JwtProperties.class)
public class SecurityApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SecurityApplication.class, args);
    }
}

