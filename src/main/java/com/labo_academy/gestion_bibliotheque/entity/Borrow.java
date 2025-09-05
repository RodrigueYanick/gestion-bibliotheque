package com.labo_academy.gestion_bibliotheque.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//creation de la table borrow
@Entity
@Table(name = "borrow")
@AllArgsConstructor
@Getter
@Setter

public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowedId;
    @Column(unique = true, nullable = false, length = 100)
    private String borrowedNumber;
    @Column(nullable = false)
    private LocalDate borrowedDate;  // date de l'emprunt
    @Column(nullable = false)
    private LocalDate returnDate;  // date prevu pour le retour de l'emprunt
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)  // le statut de l'emprunt
    private BorrowedStatus status;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)  // relation entre plusieur emprunt et un document
    private Document document;

    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "borrow")  // relation entre un emprunt et une facture
    private BorrowedBill facture;

    @ManyToOne
    @JoinColumn(name = "suscriber_id",nullable = false)  // relation entre emprunt et abonne
    private Subscribers suscriber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "borrow")
    private Returned rendre;

    @PrePersist
    public void PrePersist(){
        borrowedDate = LocalDate.now();
    }

    @PrePersist
    public void returnDateMethode(){
        returnDate = LocalDate.now();
        returnDate = returnDate.plusDays(10);
    }

    // Constructeur
    public Borrow() {
    }

    public Borrow(Long borrowedId, LocalDate borrowedDate, LocalDate returnDate, BorrowedStatus status) {
        this.borrowedId = borrowedId;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getBorrowedId() {
        return borrowedId;
    }

    public void setBorrowedId(Long borrowedId) {
        this.borrowedId = borrowedId;
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

    public BorrowedStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowedStatus status) {
        this.status = status;
    }


}
