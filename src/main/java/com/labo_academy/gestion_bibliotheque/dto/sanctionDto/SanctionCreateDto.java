package com.labo_academy.gestion_bibliotheque.dto.sanctionDto;

public class SanctionCreateDto {

    private String sanctionNumber;

    // Constructeur
    public SanctionCreateDto(String sanctionNumber) {
        this.sanctionNumber = sanctionNumber;
    }

    // Getter & Setter
    public String getSanctionNumber() {
        return sanctionNumber;
    }

    public void setSanctionNumber(String sanctionNumber) {
        this.sanctionNumber = sanctionNumber;
    }
}
