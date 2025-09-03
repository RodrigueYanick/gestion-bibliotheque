package com.labo_academy.gestion_bibliotheque.dto.dictionaryDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DictionaryResponseDto {

    private String Language;
    private int numberWords;

}
