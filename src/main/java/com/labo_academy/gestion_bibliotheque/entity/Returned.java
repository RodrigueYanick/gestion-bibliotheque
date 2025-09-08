package com.labo_academy.gestion_bibliotheque.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "returned")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Returned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Date effective du retour (initialisée automatiquement)
    @Column(nullable = false)
    private LocalDate effectiveReturnDate;

    // Identifiant unique du retour (ex: code transaction)
    @Column(name = "return_number", unique = true, nullable = false, length = 50)
    private String returnNumber;

    @PrePersist
    public void prePersist() {
        effectiveReturnDate = LocalDate.now();
    }

    // Relation avec l'emprunt (un retour correspond à un seul emprunt)
    @OneToOne
    @JoinColumn(name = "borrow_id", nullable = false)
    private Borrow borrow;

    // Relation avec une sanction éventuelle
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "returned")
    private Sanction sanction;

    // Relation avec la facture de retour
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "returned")
    private ReturnedBill returnedBill;
}