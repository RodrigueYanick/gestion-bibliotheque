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
import lombok.NoArgsConstructor;
import lombok.Setter;

//creation de la table borrow
@Entity
@Table(name = "borrow")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowedId;
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
    private Suscriber suscriber;

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

}
