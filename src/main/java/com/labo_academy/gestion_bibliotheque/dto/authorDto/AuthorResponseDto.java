package com.labo_academy.gestion_bibliotheque.dto.authorDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor   // constructeur vide
@AllArgsConstructor  // constructeur avec tous les champs
public class AuthorResponseDto {

    private Long authorId;
    private String lastName;
    private String firstName;
    private String immatriculation;
    private String nationality;
}
