package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.login.LoginCreateDto;
import com.labo_academy.gestion_bibliotheque.security.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Contrôleur d'authentification (login)
 * Permet à un utilisateur de se connecter et de recevoir un token JWT
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * Point d'entrée pour le login.
     * Reçoit un email et un mot de passe, et renvoie un token JWT si les identifiants sont valides.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginCreateDto dto) {
        try {
            // 1) Vérifier les identifiants
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
            );

            // 2) Récupérer l'utilisateur authentifié
            UserDetails user = (UserDetails) auth.getPrincipal();

            // 3) Récupérer le rôle de l'utilisateur (le premier trouvé)
            String role = "VISITOR"; // valeur par défaut
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                role = authority.getAuthority().replace("ROLE_", "");
                break; // arrêter à la première autorité trouvée
            }

            // 4) Générer un token JWT contenant l'email + le rôle
            String token = jwtUtil.generateToken(user.getUsername(), role);

            // 5) Préparer la réponse JSON
            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            // 6) Retourner le token
            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            // 7) Si échec d'authentification → retour 401
            return ResponseEntity.status(401).body("Identifiants invalides");
        }
    }
}
