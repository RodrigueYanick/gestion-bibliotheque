package com.labo_academy.gestion_bibliotheque.dto.returnBillDto;

import jakarta.validation.constraints.NotBlank;

public class ReturnedBillCreateDto {

    @NotBlank(message = "Le numéro de facture est obligatoire")
    private String billNumber;

    public ReturnedBillCreateDto(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }
}
