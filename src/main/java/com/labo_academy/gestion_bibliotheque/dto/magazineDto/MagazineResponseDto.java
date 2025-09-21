package com.labo_academy.gestion_bibliotheque.dto.magazineDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MagazineResponseDto extends DocumentResponseDto {

    private String issn;
    private int validationPeriod;

}
