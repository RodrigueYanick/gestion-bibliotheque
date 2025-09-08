package com.labo_academy.gestion_bibliotheque.dto.usersDto;

import com.labo_academy.gestion_bibliotheque.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersCreateDto {

    @NotBlank(message = "Le nom est obligatoire")
    private String lastName;

    @NotBlank(message = "Le prénom est obligatoire")
    private String firstName;

    @NotNull(message = "La date de naissance est obligatoire")
    private LocalDate birthDate;

    @NotBlank(message = "Le mot de passe est obligatoire")
    private String password;

    @Email(message = "L'email doit être valide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    private String address;

    @NotNull(message = "Le rôle est obligatoire")
    private Role role;

    
    // URL de l'image de profil (optionnelle).
    private String imageUrl;
}
