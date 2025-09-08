package com.labo_academy.gestion_bibliotheque.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sanction")
@Getter
@Setter
public class Sanction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // identifiant unique de la sanction

    @Column(nullable = false)
    private double amount;  // montant de la sanction

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SanctionStatus status;  // statut de la sanction (PAID, UNPAID...)

    @Column(name = "sanction_number", unique = true, nullable = false, length = 50)
    private String sanctionNumber;  // numéro unique de la sanction

    @OneToOne
    @JoinColumn(name = "returned_id", nullable = false)
    private Returned returned;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "sanction")
    private SanctionBill sanctionBill;

    @PrePersist
    private void generateSanctionNumber() {
        if (sanctionNumber == null) {
            sanctionNumber = "SAN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
    }

    public Sanction() {}

    public Sanction(Long id, double amount, SanctionStatus status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }
}
