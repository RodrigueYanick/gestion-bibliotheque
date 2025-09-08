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
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// Création de la table "borrow"
@Entity
@Table(name = "borrow")
@Getter
@Setter

public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Clé primaire générée automatiquement par la base
    private Long borrowedId;

    @Column(unique = true, nullable = false, length = 100)
    // Numéro unique d’emprunt (par exemple : BORR-2025-001)
    private String borrowedNumber;

    @Column(nullable = false)
    // Date de l’emprunt (remplie automatiquement à la création)
    private LocalDate borrowedDate;

    @Column(nullable = false)
    // Date prévue pour le retour du document
    private LocalDate returnDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)  
    // Statut de l’emprunt (ex: EN_COURS, RENDU, EN_RETARD)
    private BorrowedStatus status;

    // --- Relations ---

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    // Plusieurs emprunts peuvent concerner un même document
    private Document document;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "borrow")
    // Un emprunt peut avoir une facture (relation 1:1)
    private BorrowedBill facture;

    @ManyToOne
    @JoinColumn(name = "suscriber_id", nullable = false)
    // Plusieurs emprunts peuvent appartenir à un même abonné
    private LibraryClient subscriber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "borrow")
    // Relation 1:1 entre un emprunt et un retour
    private Returned rendre;

    // --- Méthodes utilitaires ---

    // Méthode appelée avant l'insertion pour définir les dates par défaut
    public void PrePersist(){
        borrowedDate = LocalDate.now();       // Date d’emprunt = aujourd’hui
        returnDate = borrowedDate.plusDays(10); // Retour prévu = +10 jours
    }

    // --- Constructeurs ---
    public Borrow() {}

    public Borrow(Long borrowedId, LocalDate borrowedDate, LocalDate returnDate, BorrowedStatus status) {
        this.borrowedId = borrowedId;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    // --- Getters et setters explicites ---
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
