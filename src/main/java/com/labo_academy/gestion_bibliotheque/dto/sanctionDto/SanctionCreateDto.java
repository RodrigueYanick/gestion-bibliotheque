package com.labo_academy.gestion_bibliotheque.dto.sanctionDto;

public class SanctionCreateDto {

    private String returnedNumber;

    // Constructeur
    public SanctionCreateDto(String returnedNumber) {
        this.returnedNumber = returnedNumber;
    }

    // Getter & Setter
    public String getReturnedNumber() {
        return returnedNumber;
    }

    public void setReturnedNumber(String returnedNumber) {
        this.returnedNumber = returnedNumber;
    }
}
