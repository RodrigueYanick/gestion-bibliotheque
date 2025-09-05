package com.labo_academy.gestion_bibliotheque.dto.borrowDto;

import java.time.LocalDate;

import com.labo_academy.gestion_bibliotheque.entity.BorrowedStatus;

import java.time.LocalDate;

public class BorrowResponseDto {

    private Long borrowedId;
    private BorrowedStatus status;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private String documentMatricule;
    private String suscribersEmail;

    // Constructor
    public BorrowResponseDto(Long borrowedId, BorrowedStatus status, LocalDate borrowedDate, LocalDate returnDate,String documentMatricule,String suscribersEmail) {
        this.borrowedId = borrowedId;
        this.status = status;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.documentMatricule = documentMatricule;
        this.suscribersEmail = suscribersEmail;
    }

    // Getters and Setters


    public String getDocumentMatricule() {
        return documentMatricule;
    }

    public void setDocumentMatricule(String documentMatricule) {
        this.documentMatricule = documentMatricule;
    }

    public String getSuscribersEmail() {
        return suscribersEmail;
    }

    public void setSuscribersEmail(String suscribersEmail) {
        this.suscribersEmail = suscribersEmail;
    }

    public Long getBorrowedId() {
        return borrowedId;
    }

    public void setBorrowedId(Long borrowedId) {
        this.borrowedId = borrowedId;
    }

    public BorrowedStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowedStatus status) {
        this.status = status;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
