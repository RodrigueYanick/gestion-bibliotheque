package com.labo_academy.gestion_bibliotheque.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtil {

    // Cle secrète pour signer le token (a mettre dans application.properties plus tard)
    private static final String SECRET = "SecretKey123";

    // Durée de validité du token (ici 1 jour = 24h)
    private static final long EXPIRATION_TIME = 864_000_00; 

    // ===============================
    // 1 Générer un token
    // ===============================
    public static String generateToken(String username) {
        // username = identifiant de l’utilisateur (par ex : email)
        return Jwts.builder()
                .setSubject(username) // Sujet = identifiant principal dans le token
                .setIssuedAt(new Date()) // Date de création du token
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Date d’expiration
                .signWith(SignatureAlgorithm.HS512, SECRET) // Signature avec clé secrète
                .compact(); // Générer le token final
    }

    // ===============================
    // 2️ Extraire les informations du token
    // ===============================
    public static Claims getClaims(String token) {
        // Décrypter le token et récupérer son contenu
        return Jwts.parser()
                .setSigningKey(SECRET) // Vérifier avec la clé secrète
                .parseClaimsJws(token)
                .getBody(); // Retourne le "corps" du token (claims)
    }

    // ===============================
    // 3️ Récupérer le username depuis le token
    // ===============================
    public static String getUsername(String token) {
        return getClaims(token).getSubject(); // le "subject" = username
    }

    // ===============================
    // 4️ Vérifier si un token est encore valide
    // ===============================
    public static boolean isTokenValid(String token) {
        try {
            Claims claims = getClaims(token);
            Date expirationDate = claims.getExpiration();
            return expirationDate.after(new Date()); // vrai si la date d’expiration est dans le futur
        } catch (Exception e) {
            return false; // si une erreur arrive (token invalide, expiré, modifié)
        }
    }
}
