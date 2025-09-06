package com.labo_academy.gestion_bibliotheque.dto.returnBillDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import lombok.Getter;
import lombok.Setter;

import javax.xml.stream.events.StartDocument;

@Getter
@Setter
public class ReturnedBillResponseDto {

    private Long billNumber;
    private String effectiveReturnDateNumber;
    private String subscribersLastName;
    private String subscribersFirstname;
    private String subscribersAdresse;
    private String documentMatricule;
    private String documentTitle;
    private LocalDate borrowedDate;
    private LocalDate borrowedReturnDate;
    private LocalDate effectiveReturnedDate;
    private int dateDiff;
    private double sanction;

    public ReturnedBillResponseDto(Long billNumber, String effectiveReturnDateNumber, String subscribersLastName, String subscribersFirstname, String subscribersAdresse, String documentMatricule, String documentTitle, LocalDate borrowedDate, LocalDate borrowedReturnDate, int dateDiff, double sanction) {
        this.billNumber = billNumber;
        this.effectiveReturnDateNumber = effectiveReturnDateNumber;
        this.subscribersLastName = subscribersLastName;
        this.subscribersFirstname = subscribersFirstname;
        this.subscribersAdresse = subscribersAdresse;
        this.documentMatricule = documentMatricule;
        this.documentTitle = documentTitle;
        this.borrowedDate = borrowedDate;
        this.borrowedReturnDate = borrowedReturnDate;
        this.effectiveReturnedDate = effectiveReturnedDate;
        this.dateDiff = dateDiff;
        this.sanction = sanction;
    }

    public String getEffectiveReturnDateNumber() {
        return effectiveReturnDateNumber;
    }

    public void setEffectiveReturnDateNumber(String effectiveReturnDateNumber) {
        this.effectiveReturnDateNumber = effectiveReturnDateNumber;
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

    public LocalDate getEffectiveReturnedDate() {
        return effectiveReturnedDate;
    }

    public void setEffectiveReturnedDate(LocalDate effectiveReturnedDate) {
        this.effectiveReturnedDate = effectiveReturnedDate;
    }

    public int getDateDiff() {
        return dateDiff;
    }

    public void setDateDiff(int dateDiff) {
        this.dateDiff = dateDiff;
    }

    public double getSanction() {
        return sanction;
    }

    public void setSanction(double sanction) {
        this.sanction = sanction;
    }

    public Long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(Long billNumber) {
        this.billNumber = billNumber;
    }
}
