package com.labo_academy.gestion_bibliotheque.dto.returnBillDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ReturnedBillResponseDto {

    private Long billNumber;

    public ReturnedBillResponseDto(Long billNumber) {
        this.billNumber = billNumber;
    }

    public Long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(Long billNumber) {
        this.billNumber = billNumber;
    }
}
