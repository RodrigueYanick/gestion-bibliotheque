package com.labo_academy.gestion_bibliotheque.dto.dictionaryDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DictionaryCreateDto extends DocumentCreateDto {

    @NotBlank(message = "La langue est obligatoire")
    private String language;

    @Min(value = 1, message = "Le nombre de mots doit être supérieur à 0")
    private int numberWords;

}
