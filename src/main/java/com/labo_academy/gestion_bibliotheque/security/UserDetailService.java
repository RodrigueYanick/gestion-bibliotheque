package com.labo_academy.gestion_bibliotheque.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Cette méthode est appelée automatiquement lors de la tentative de connexion.
     * Elle doit retourner les informations de l'utilisateur correspondant à l'email donné.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // On récupère l'utilisateur en base à partir de son email
        Users user = usersRepository.findByEmail(username);

        // Si l'utilisateur n'existe pas, on lève une exception
        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + username);
        }

        // Création d’une autorité (rôle) à partir de l'énum Role de l'utilisateur
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority("ROLE_" + user.getRole().name());

        // On retourne un objet User de Spring Security contenant :
        // - son email (nom d'utilisateur)
        // - son mot de passe (déjà encodé en BDD)
        // - sa liste d'autorités
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),   
                Collections.singletonList(authority)
        );
    }
}
