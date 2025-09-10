package com.labo_academy.gestion_bibliotheque.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final String SECRET = "SecretKey123"; // meme cle que dans AuthenticationFilter

    public JWTAuthorizationFilter(org.springframework.security.authentication.AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        // 1. Récupérer le header "Authorization"
        String header = request.getHeader("Authorization");

        // 2. Vérifier si le header est présent et commence par "Bearer"
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response); // si pas de token, on continue sans rien faire
            return;
        }

        // 3. Extraire le token sans le mot "Bearer"
        String token = header.replace("Bearer ", "");

        // 4. Vérifier le token et récupérer les infos dedans
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject(); // ici c’est l’email mis dans le subject

        if (username != null) {
            // 5. Créer une authentification pour Spring Security
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());

            // 6. Dire à Spring Security "cet utilisateur est connecté"
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 7. Continuer le filtre
        chain.doFilter(request, response);
    }
}
