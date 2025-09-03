package com.labo_academy.gestion_bibliotheque.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    private Long idEmprunt;
    @Column(nullable = false)
    private LocalDate borrowedDate;  // date de l'emprunt
    @Column(nullable = false)
    private LocalDate returnDate;  // date prevu pour le retour de l'emprunt
    @Column(nullable = true)
    private LocalDate effectifReturnDate;  // date effectif du retour de l'emprunt
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)  // le statut de l'emprunt
    private BorrowedStatus status;

    @OneToOne
    @JoinColumn(name = "sanction_id", nullable = true)  // relation entre un emprunt et une sanction
    private Sanction sanction;
    
    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)  // relation entre plusieur emprunt et un document
    private Document document;

    @OneToOne
    @JoinColumn(name = "facture_id", nullable = true)  // relation entre un emprunt et une facture
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "suscriber_id",nullable = false)  // relation entre emprunt et abonne
    private Suscriber suscriber;

}
