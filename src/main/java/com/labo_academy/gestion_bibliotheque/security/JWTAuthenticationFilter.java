package com.labo_academy.gestion_bibliotheque.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labo_academy.gestion_bibliotheque.entity.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Date;

@AllArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    // Tenter de s’authentifier avec email + mot de passe
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            // Lire le JSON envoyé dans la requête et le transformer en objet Users
            Users user = new ObjectMapper().readValue(request.getInputStream(), Users.class);

            // Créer un token d’authentification avec email + mot de passe
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),  // login = email
                            user.getPassword() // mot de passe
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la lecture des informations de connexion", e);
        }
    }

    // Si l’authentification réussit → générer le JWT et l’envoyer au client
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        // Récupérer l’utilisateur authentifié
        User user = (User) authResult.getPrincipal();

        // Créer un token JWT
        String token = Jwts.builder()
                .setSubject(user.getUsername()) // ici = email
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_00)) // expiration = 1 jour
                .signWith(SignatureAlgorithm.HS512, "SecretKey123") // clé secrète (à sécuriser)
                .compact();

        // Retourner le token dans la réponse HTTP (dans l’entête)
        response.addHeader("Authorization", "Bearer " + token);

        // (optionnel) écrire aussi le token dans le corps de la réponse
        response.setContentType("application/json");
        response.getWriter().write("{\"token\": \"" + token + "\"}");
    }
}
