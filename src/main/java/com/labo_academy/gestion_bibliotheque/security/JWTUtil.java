package com.labo_academy.gestion_bibliotheque.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

    // Clé secrète utilisée pour signer et vérifier les tokens JWT
    // ⚠️ Elle doit faire au moins 32 caractères pour être valide avec HS256
    private static final String SECRET = "MaCleSuperSecreteDe32CaracteresMin123456";

    // Durée de validité d’un token en millisecondes (ici environ 1 jour)
    private static final long EXPIRATION_TIME = 864_000_00;

    // Génère un objet clé à partir de la chaîne secrète (pour signer les tokens)
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    /**
     * Génère un token JWT contenant :
     * - le nom d'utilisateur
     * - le rôle (précédé de "ROLE_")
     * - la date d'émission et d'expiration
     */
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)                               // Nom d'utilisateur
                .claim("roles", "ROLE_" + role)                      // Rôle dans les claims
                .setIssuedAt(new Date())                             // Date de création du token
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Expiration
                .signWith(KEY, SignatureAlgorithm.HS256)             // Signature avec clé + algorithme
                .compact();                                          // Génère la chaîne JWT finale
    }

    /**
     * Récupère les informations (claims) contenues dans un token JWT.
     * Vérifie aussi que la signature est valide grâce à la clé secrète.
     */
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)                 // clé pour vérifier la signature
                .build()
                .parseClaimsJws(token)              // vérifie et décode le token
                .getBody();                         // renvoie le contenu (claims)
    }

    /**
     * Récupère uniquement le nom d'utilisateur stocké dans le token.
     */
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    /**
     * Vérifie si le token est encore valide (non expiré et signature correcte).
     */
    public boolean isTokenValid(String token) {
        try {
            Claims claims = getClaims(token);
            Date expiration = claims.getExpiration();
            return expiration.after(new Date());  // compare la date d'expiration à maintenant
        } catch (Exception e) {
            return false;  // token invalide ou expiré
        }
    }
}
