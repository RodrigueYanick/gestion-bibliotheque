package com.labo_academy.gestion_bibliotheque.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // indique que cette classe contient la configuration Spring Security
public class SecurityConfig {

    // Filtre personnalisé qui va valider le token JWT dans chaque requête
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    // Service qui va charger les utilisateurs depuis la base de données
    private final UserDetailsService userDetailsService;

    // Injection via constructeur
    public SecurityConfig(JWTAuthorizationFilter jwtAuthorizationFilter, UserDetailsService userDetailsService) {
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
        this.userDetailsService = userDetailsService;
    }

    /**
     * ⚙️ Configuration principale de la sécurité HTTP
     * - désactive CSRF
     * - configure les sessions en mode STATELESS (sans stockage côté serveur)
     * - définit les routes publiques et protégées
     * - ajoute le filtre JWT avant le filtre d'authentification standard
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   AuthenticationManager authManager) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // pas de protection CSRF (API REST)
                .sessionManagement(session -> 
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // pas de session côté serveur
                .authorizeHttpRequests(auth -> auth
                // // Authentification
                // .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()

                // // Créations par le DIRECTOR uniquement
                // .requestMatchers(HttpMethod.POST, "/api/director/create").hasRole("DIRECTOR")
                // .requestMatchers(HttpMethod.POST, "/api/agent/create").hasRole("DIRECTOR")
                // .requestMatchers(HttpMethod.POST, "/api/librarian/create").hasRole("DIRECTOR")

                // // Création d'un client (visitor) accessible à tous (public)
                // .requestMatchers(HttpMethod.POST, "/api/libraryClient/create").permitAll()

                // // Gestion des clients par AGENT (et DIRECTOR)
                // .requestMatchers("/api/visitor/**").hasAnyRole("AGENT","DIRECTOR")
                // .requestMatchers("/api/subscriber/**").hasAnyRole("AGENT","DIRECTOR")

                // // Droits propres au SUBSCRIBER
                // .requestMatchers("/api/borrow/**").hasRole("SUBSCRIBER")
                // .requestMatchers("/api/return/**").hasRole("SUBSCRIBER")
                // .requestMatchers("/api/sanction/**").hasRole("SUBSCRIBER")

                // // Droits propres au LIBRARIAN (et DIRECTOR)
                // .requestMatchers("/api/book/**").hasAnyRole("LIBRARIAN","DIRECTOR")
                // .requestMatchers("/api/magazine/**").hasAnyRole("LIBRARIAN","DIRECTOR")
                // .requestMatchers("/api/copy/**").hasAnyRole("LIBRARIAN","DIRECTOR")
                // .requestMatchers("/api/dictionary/**").hasAnyRole("LIBRARIAN","DIRECTOR")
                // .requestMatchers("/api/publication/**").hasAnyRole("LIBRARIAN","DIRECTOR")
                // .requestMatchers("/api/category/**").hasAnyRole("LIBRARIAN","DIRECTOR")
                // .requestMatchers("/api/author/**").hasAnyRole("LIBRARIAN","DIRECTOR")
                // .requestMatchers("/api/borrowBill/**").hasAnyRole("LIBRARIAN","DIRECTOR")
                // .requestMatchers("/api/returnBill/**").hasAnyRole("LIBRARIAN","DIRECTOR")
                // .requestMatchers("/api/sanctionBill/**").hasAnyRole("LIBRARIAN","DIRECTOR")

                // // Toute autre requête => authentifiée
                // .anyRequest().authenticated()
                .anyRequest().permitAll() // ⛔ autorise tout sans authentification
            )

                // ajoute notre filtre JWT avant celui de Spring
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    /**
     * ⚙️ Déclare comment Spring doit authentifier les utilisateurs
     * Ici on utilise un DaoAuthenticationProvider qui :
     * - charge les utilisateurs via UserDetailsService
     * - vérifie les mots de passe avec BCrypt
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService); // pour récupérer les utilisateurs en BDD
        provider.setPasswordEncoder(passwordEncoder());      // pour comparer les mots de passe chiffrés
        return provider;
    }

    /**
     * ⚙️ Fournit le AuthenticationManager
     * qui orchestre tout le processus de login
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * ⚙️ Déclare l’encodeur de mot de passe (BCrypt)
     * qui va chiffrer et comparer les mots de passe
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
