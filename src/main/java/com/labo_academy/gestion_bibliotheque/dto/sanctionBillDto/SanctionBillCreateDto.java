package com.labo_academy.gestion_bibliotheque.dto.sanctionBillDto;

public class SanctionBillCreateDto {

    private String sanctionBillNumber;

    public SanctionBillCreateDto(String sanctionBillNumber) {
        this.sanctionBillNumber = sanctionBillNumber;
    }

    public String getSanctionBillNumber() {
        return sanctionBillNumber;
    }

    public void setSanctionBillNumber(String sanctionBillNumber) {
        this.sanctionBillNumber = sanctionBillNumber;
    }
}
