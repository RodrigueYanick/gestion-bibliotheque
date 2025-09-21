package com.labo_academy.gestion_bibliotheque.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "sanction_bill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanctionBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sanction_bill_number", unique = true, nullable = false, length = 50)
    private String sanctionBillNumber;  // numéro unique de facture

    @OneToOne
    @JoinColumn(name = "sanction_id", nullable = false)
    private Sanction sanction;

    @PrePersist
    private void generateBillNumber() {
        if (sanctionBillNumber == null) {
            sanctionBillNumber = "SANB-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
    }

    public SanctionBill(Sanction sanction) {
        this.sanction = sanction;
    }
}