package com.labo_academy.gestion_bibliotheque.dto.returnBillDto;

import jakarta.validation.constraints.NotBlank;

public class ReturnedBillCreateDto {

    @NotBlank(message = "Le numéro de facture est obligatoire")
    private String returnedNumber;

    public ReturnedBillCreateDto(String returnedNumber) {
        this.returnedNumber = returnedNumber;
    }

    public String getReturnedNumber() {
        return returnedNumber;
    }

    public void setReturnedNumber(String returnedNumber) {
        this.returnedNumber = returnedNumber;
    }
}
