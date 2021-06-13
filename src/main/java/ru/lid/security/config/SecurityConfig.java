package ru.lid.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import ru.lid.security.service.UserService;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserService userService;

    @Bean
    public UserDetailsService userDetailsService() {
       var userDetailsService = new InMemoryUserDetailsManager();
       userService.getUsers().forEach(userDetailsService::createUser);
       return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
