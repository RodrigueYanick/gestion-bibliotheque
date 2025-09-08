package com.labo_academy.gestion_bibliotheque.dto.returnedDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnedCreateDto {

    private String returnedEmail;
    private String documentMatricule;
    
}
