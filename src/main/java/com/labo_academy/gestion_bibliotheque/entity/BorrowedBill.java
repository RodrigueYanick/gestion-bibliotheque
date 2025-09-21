package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
// Création de la table "facture"
@Entity
@Table(name = "facture")
@Getter
@Setter
public class BorrowedBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    // Identifiant unique de la facture (clé primaire auto-incrémentée)
    private Long borrowedId;

    // Numéro unique de la facture de retour
    @Column(unique = true, nullable = false, length = 50)
    private String billNumber;

    @OneToOne
    @JoinColumn(name = "borrow_id", nullable = true)  
    // Relation 1:1 avec Borrow
    // - Chaque facture est liée à un seul emprunt
    // - nullable = true → possibilité d’avoir une facture non reliée immédiatement à un emprunt
    private Borrow borrow;

}
