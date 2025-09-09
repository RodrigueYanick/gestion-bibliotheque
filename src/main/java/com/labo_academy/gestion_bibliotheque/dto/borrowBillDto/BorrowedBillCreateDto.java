package com.labo_academy.gestion_bibliotheque.dto.borrowBillDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
 @NoArgsConstructor
@AllArgsConstructor
public class BorrowedBillCreateDto {

    @NotBlank(message = "Le numéro d'emprunt est obligatoire")
    private String borrowedNumber;
}
