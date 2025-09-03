package com.labo_academy.gestion_bibliotheque.dto.magazineDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MagazineCreateDto extends DocumentCreateDto {

    private String issn;
    private int validationPeriod;    

}
