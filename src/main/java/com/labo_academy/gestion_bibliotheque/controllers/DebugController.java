package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.entity.Users;
import com.labo_academy.gestion_bibliotheque.repository.UsersRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Endpoint de debug pour vérifier facilement si `passwordEncoder.matches(raw, storedHash)` est vrai.
 * WARNING: Debug ONLY - supprimer ou protéger en prod.
 */
@RestController
@RequestMapping("/debug")
public class DebugController {

    // private final UsersRepository usersRepository;
    // private final PasswordEncoder passwordEncoder;

    // public DebugController(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
    //     this.usersRepository = usersRepository;
    //     this.passwordEncoder = passwordEncoder;
    // }

    // @PostMapping("/password-check")
    // public ResponseEntity<?> checkPassword(@RequestBody Map<String, String> body) {
    //     String email = body.get("email");
    //     String raw = body.get("password");
    //     if (email == null || raw == null) {
    //         return ResponseEntity.badRequest().body(Map.of("error", "email et password obligatoires"));
    //     }

    //     Users u = usersRepository.findByEmail(email);
    //     if (u == null) return ResponseEntity.status(404).body(Map.of("error", "user not found"));

    //     boolean matches = passwordEncoder.matches(raw, u.getPassword());

    //     Map<String, Object> res = new HashMap<>();
    //     res.put("email", email);
    //     res.put("raw", raw); // debug only
    //     res.put("storedHash", u.getPassword());
    //     res.put("storedHashLength", u.getPassword() == null ? 0 : u.getPassword().length());
    //     res.put("matches", matches);

    //     return ResponseEntity.ok(res);
    // }
}
