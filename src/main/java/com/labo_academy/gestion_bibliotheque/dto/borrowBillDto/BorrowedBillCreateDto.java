package com.labo_academy.gestion_bibliotheque.dto.borrowBillDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowedBillCreateDto {

    @NotBlank(message = "Le numéro de facture est obligatoire")
    private String borrowedNumber;

}
