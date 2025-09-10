package com.labo_academy.gestion_bibliotheque.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Encoder pour les mots de passe
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager (utilisé dans le login)
    @Bean
    public AuthenticationManager authenticationManager(
            HttpSecurity http,
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService
    ) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                   .userDetailsService(userDetailsService)
                   .passwordEncoder(passwordEncoder)
                   .and()
                   .build();
    }

    // Configuration principale de la sécurité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT = pas de session
            .and()
            .authorizeHttpRequests()
                .requestMatchers("/login").permitAll() // login public
                .requestMatchers("/libraryClient/delete/**").hasRole("AGENT")   // seul l’AGENT peut supprimer un client
                .requestMatchers("/books/delete/**").hasRole("LIBRARIAN")       // seul le BIBLIOTHECAIRE peut supprimer un livre
                .requestMatchers("/admin/**").hasRole("DIRECTOR")               // seul le DIRECTEUR peut tout gérer
                .anyRequest().authenticated(); // le reste protégé

            http.addFilter(new JWTAuthenticationFilter(authenticationManager(http, passwordEncoder(), userDetailsService)));
            http.addFilter(new JWTAuthorizationFilter(authenticationManager(http, passwordEncoder(), userDetailsService)));

        return http.build();
    }
}
