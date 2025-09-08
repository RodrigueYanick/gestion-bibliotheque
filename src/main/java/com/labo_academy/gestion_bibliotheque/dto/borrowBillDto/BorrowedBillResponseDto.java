package com.labo_academy.gestion_bibliotheque.dto.borrowBillDto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BorrowedBillResponseDto {

    private Long borrowedId;
    // private String borrowedNumber;
    private String subscribersLastName;
    private String subscribersFirstname;
    private String subscribersAddresse;
    private String documentMatricule;
    private String documentTitle;
    private LocalDate borrowedDate;
    private LocalDate borrowedReturnDate;

    public BorrowedBillResponseDto(Long borrowedId, String subscribersLastName, String subscribersFirstname, String subscribersAddresse, String documentMatricule, String documentTitle, LocalDate borrowedDate, LocalDate borrowedReturnDate) {
        this.borrowedId = borrowedId;
        this.subscribersLastName = subscribersLastName;
        this.subscribersFirstname = subscribersFirstname;
        this.subscribersAddresse = subscribersAddresse;
        this.documentMatricule = documentMatricule;
        this.documentTitle = documentTitle;
        this.borrowedDate = borrowedDate;
        this.borrowedReturnDate = borrowedReturnDate;
    }

    public Long getBillNumber() {
        return borrowedId;
    }

    public void setBillNumber(Long borrowedId) {
        this.borrowedId = borrowedId;
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

    public String getsubscribersAddresse() {
        return subscribersAddresse;
    }

    public void setsubscribersAddresse(String subscribersAddresse) {
        this.subscribersAddresse = subscribersAddresse;
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
