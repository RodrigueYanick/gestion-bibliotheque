package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// creation de la table facture
@Entity
@Table(name = "facture")
@Getter
@Setter

public class BorrowedBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // identifiant unique de la facture
    private Long billNumber;

    @OneToOne
    @JoinColumn(name = "borrow_id", nullable = true)  // relation entre une facture et un emprunt
    private Borrow borrow;

}
