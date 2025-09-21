package com.labo_academy.gestion_bibliotheque.dto.dictionaryDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DictionaryResponseDto extends DocumentResponseDto {

    private String language;
    private int numberWords;

}
