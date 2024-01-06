package com.javaguides.todo.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Basic Authentication Type
@Configuration
@AllArgsConstructor
@EnableMethodSecurity // To do a method level security
public class SpringSecurityConfig {

    @Bean
    public  static PasswordEncoder passwordEncoder(){
        // The BCryptPasswordEncoder implementation uses the widely supported bcrypt algorithm to hash the password.
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable Cross-Site Request Forgery (CSRF) protection
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((authorize) -> {
            // Allow all users to access URLs starting with /api/auth/
            authorize.requestMatchers("/api/auth/**").permitAll();
            // Allow pre-flight OPTIONS requests for all URLs
            authorize.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
            // Require authentication for any other requests
            authorize.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());// Configure HTTP Basic Authentication

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
