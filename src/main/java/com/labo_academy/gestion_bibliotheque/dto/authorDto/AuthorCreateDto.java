package com.labo_academy.gestion_bibliotheque.dto.authorDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor   // constructeur vide
@AllArgsConstructor  // constructeur avec tous les champs
public class AuthorCreateDto {

    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères")
    private String lastName;

    @NotBlank(message = "Le prénom est obligatoire")
    @Size(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères")
    private String firstName;

    @NotBlank(message = "L'immatriculation est obligatoire")
    @Size(max = 30, message = "L'immatriculation ne doit pas dépasser 30 caractères")
    private String immatriculation;

    @NotBlank(message = "La nationalité est obligatoire")
    @Size(max = 50, message = "La nationalité ne doit pas dépasser 50 caractères")
    private String nationality;
}
