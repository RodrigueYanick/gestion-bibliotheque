package com.labo_academy.gestion_bibliotheque.dto.returnBillDto;

import java.time.LocalDate;

public class ReturnedBillCreateDto {

    private String effectiveReturnDateNumber;

    public ReturnedBillCreateDto(String effectiveReturnDateNumber) {
        this.effectiveReturnDateNumber = effectiveReturnDateNumber;
    }

    public String getEffectiveReturnDateNumber() {
        return effectiveReturnDateNumber;
    }

    public void setEffectiveReturnDateNumber(String effectiveReturnDateNumber) {
        this.effectiveReturnDateNumber = effectiveReturnDateNumber;
    }
}
