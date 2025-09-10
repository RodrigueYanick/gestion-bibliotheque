package com.labo_academy.gestion_bibliotheque.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.labo_academy.gestion_bibliotheque.entity.Users;
import com.labo_academy.gestion_bibliotheque.repository.UsersRepository;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository; 
    // On injecte le repository qui permet d’accéder aux utilisateurs dans la base de données

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Ici "username" est la valeur envoyée par l’utilisateur lors de la connexion (login)
        // Dans ton cas, tu cherches encore avec lastName, mais on pourra changer pour email plus tard

        Users user = usersRepository.findByEmail(username);
        // On cherche l’utilisateur dans la base de données avec son "lastName"

        if (user == null) {
            // Si aucun utilisateur n’est trouvé, on lève une exception
            // Spring Security va gérer ça automatiquement et refuser l’authentification
            throw new UsernameNotFoundException("Utilisateur non trouvé avec le nom : " + username);
        }

        // Transformer le rôle de l’utilisateur (Enum) en autorité reconnue par Spring Security
        // Exemple : Role.LIBRARIAN -> "LIBRARIAN"
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));

        // Retourner un objet "User" de Spring Security
        // Cet objet contient : 
        // - l’identifiant de connexion (ici j’ai mis l’email au lieu du lastName car c’est plus logique)
        // - le mot de passe crypté de l’utilisateur (stocké en BDD)
        // - la liste des rôles/autorisations (authorities)
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),    // identifiant de connexion (login)
                user.getPassword(), // mot de passe crypté
                authorities         // liste des rôles associés
        );
    }
}
