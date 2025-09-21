package com.labo_academy.gestion_bibliotheque.dto.magazineDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MagazineCreateDto extends DocumentCreateDto {

    @NotBlank(message = "L'ISSN est obligatoire")
    @Size(min = 8, max = 20, message = "L'ISSN doit contenir entre 8 et 20 caractères")
    private String issn;

    @Min(value = 1, message = "La période de validité doit être supérieure à 0")
    private int validationPeriod;
}
