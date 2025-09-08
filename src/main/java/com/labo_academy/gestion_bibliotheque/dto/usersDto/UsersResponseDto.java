package com.labo_academy.gestion_bibliotheque.dto.usersDto;

import com.labo_academy.gestion_bibliotheque.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponseDto {

    private Long id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String email;
    private String address;
    private Role role;

    // URL de l'image de profil de l'utilisateur
    private String imageUrl;
}
