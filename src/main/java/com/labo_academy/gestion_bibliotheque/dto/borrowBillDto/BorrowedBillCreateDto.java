package com.labo_academy.gestion_bibliotheque.dto.borrowBillDto;

public class BorrowedBillCreateDto {

    private String borrowedNumber;

    public BorrowedBillCreateDto(String borrowedNumber) {
        this.borrowedNumber = borrowedNumber;
    }

    public String getBorrowedNumber() {
        return borrowedNumber;
    }

    public void setBorrowedNumber(String borrowedNumber) {
        this.borrowedNumber = borrowedNumber;
    }
}
