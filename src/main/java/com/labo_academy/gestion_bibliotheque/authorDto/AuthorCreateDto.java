package com.labo_academy.gestion_bibliotheque.authorDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AuthorCreateDto {

    private String lastName;
    private String firstName;
    private String immatriculation;
    private String nationalite;
    
}
