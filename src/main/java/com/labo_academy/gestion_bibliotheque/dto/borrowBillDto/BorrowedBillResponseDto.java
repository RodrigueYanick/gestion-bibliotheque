package com.labo_academy.gestion_bibliotheque.dto.borrowBillDto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BorrowedBillResponseDto {

    private Long billNumber;
    private String borrowedNumber;
    private String subscribersLastName;
    private String subscribersFirstname;
    private String subscribersAdresse;
    private String documentMatricule;
    private String documentTitle;
    private LocalDate borrowedDate;
    private LocalDate borrowedReturnDate;

    public BorrowedBillResponseDto(Long billNumber, String borrowedNumber, String subscribersLastName, String subscribersFirstname, String subscribersAdresse, String documentMatricule, String documentTitle, LocalDate borrowedDate, LocalDate borrowedReturnDate) {
        this.billNumber = billNumber;
        this.borrowedNumber = borrowedNumber;
        this.subscribersLastName = subscribersLastName;
        this.subscribersFirstname = subscribersFirstname;
        this.subscribersAdresse = subscribersAdresse;
        this.documentMatricule = documentMatricule;
        this.documentTitle = documentTitle;
        this.borrowedDate = borrowedDate;
        this.borrowedReturnDate = borrowedReturnDate;
    }

    public Long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(Long billNumber) {
        this.billNumber = billNumber;
    }

    public String getBorrowedNumber() {
        return borrowedNumber;
    }

    public void setBorrowedNumber(String borrowedNumber) {
        this.borrowedNumber = borrowedNumber;
    }

    public String getSubscribersLastName() {
        return subscribersLastName;
    }

    public void setSubscribersLastName(String subscribersLastName) {
        this.subscribersLastName = subscribersLastName;
    }

    public String getSubscribersFirstname() {
        return subscribersFirstname;
    }

    public void setSubscribersFirstname(String subscribersFirstname) {
        this.subscribersFirstname = subscribersFirstname;
    }

    public String getSubscribersAdresse() {
        return subscribersAdresse;
    }

    public void setSubscribersAdresse(String subscribersAdresse) {
        this.subscribersAdresse = subscribersAdresse;
    }

    public String getDocumentMatricule() {
        return documentMatricule;
    }

    public void setDocumentMatricule(String documentMatricule) {
        this.documentMatricule = documentMatricule;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getBorrowedReturnDate() {
        return borrowedReturnDate;
    }

    public void setBorrowedReturnDate(LocalDate borrowedReturnDate) {
        this.borrowedReturnDate = borrowedReturnDate;
    }
}
