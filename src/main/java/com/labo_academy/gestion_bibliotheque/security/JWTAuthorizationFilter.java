package com.labo_academy.gestion_bibliotheque.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    // Clé secrète utilisée pour vérifier la signature du token JWT
    // Elle doit être identique à celle utilisée pour signer les tokens
    private final String secret = "MaCleSuperSecreteDe32CaracteresMin123456";

    /**
     * Cette méthode est appelée à chaque requête HTTP entrante.
     * Elle vérifie si un token JWT est présent dans l'en-tête "Authorization"
     * et configure l'utilisateur authentifié dans le contexte de sécurité si le token est valide.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        // Récupère le contenu de l'en-tête "Authorization"
        String header = request.getHeader("Authorization");

        // Si aucun header ou qu'il ne commence pas par "Bearer ", on continue sans authentification
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        // Récupère uniquement le token (en retirant "Bearer ")
        String token = header.replace("Bearer ", "");

        try {
            // Analyse et vérifie le token grâce à la clé secrète
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))  // clé pour vérifier la signature
                    .build()
                    .parseClaimsJws(token)  // décode et valide le token
                    .getBody();              // récupère les données contenues dans le token (claims)

            // Récupère le nom d'utilisateur et les rôles depuis les claims
            String username = claims.getSubject();
            String roles = (String) claims.get("roles");

            // Si on a bien trouvé un utilisateur et des rôles dans le token
            if (username != null && roles != null) {

                // Transformation des rôles (séparés par des virgules) en objets SimpleGrantedAuthority
                List<SimpleGrantedAuthority> authorities = Arrays.stream(roles.split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

                // Création d'un objet d'authentification avec les infos de l'utilisateur
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(username, null, authorities);

                // Ajoute les détails de la requête dans l'objet d'authentification
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Enregistre l'utilisateur authentifié dans le contexte de sécurité de Spring
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

        } catch (Exception e) {
            // En cas d'erreur (token invalide ou expiré), on vide le contexte de sécurité
            SecurityContextHolder.clearContext();
        }

        // Continue le traitement de la requête dans la chaîne de filtres
        chain.doFilter(request, response);
    }
}
