package com.labo_academy.gestion_bibliotheque.dto.returnBillDto;

import java.time.LocalDate;

public class ReturnedBillCreateDto {

    private LocalDate effectiveReturnDateNumber;

    public ReturnedBillCreateDto(LocalDate effectiveReturnDateNumber) {
        this.effectiveReturnDateNumber = effectiveReturnDateNumber;
    }

    public String getEffectiveReturnDateNumber() {
        return effectiveReturnDateNumber;
    }

    public void setEffectiveReturnDateNumber(LocalDate effectiveReturnDateNumber) {
        this.effectiveReturnDateNumber = effectiveReturnDateNumber;
    }
}
