package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
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

@Entity
@Table(name = "returned_bill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnedBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Numéro unique de la facture de retour
    @Column(unique = true, nullable = false, length = 50)
    private String billNumber;

    // Relation avec le retour
    @OneToOne
    @JoinColumn(name = "returned_id", nullable = false)
    private Returned returned;
}