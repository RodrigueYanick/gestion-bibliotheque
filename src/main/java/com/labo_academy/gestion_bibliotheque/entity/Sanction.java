package com.labo_academy.gestion_bibliotheque.entity;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// creation de la table sanction
@Entity
@Table(name = "sanction")
@Getter
@Setter

public class Sanction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sanctionedId;
    @Column(nullable = false)  // montant de la sanction
    private double amount;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)  // les differents et de la sanction se trouvant dans la classe sanctionStatus
    private SanctionStatus statut;
    // Construtor


    public Sanction() {

    }

    public Sanction(Long sanctionedId, double amount, SanctionStatus statut) {
        this.sanctionedId = sanctionedId;
        this.amount = amount;
        this.statut = statut;
    }
// Getters and Setters
    public Long getSanctionedId() {
        return sanctionedId;
    }

    public void setSanctionedId(Long sanctionedId) {
        this.sanctionedId = sanctionedId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public SanctionStatus getStatut() {
        return statut;
    }

    public void setStatut(SanctionStatus statut) {
        this.statut = statut;
    }

    @OneToOne
    @JoinColumn(name = "returned_id", nullable = true)  // relation entre une sanction et un emprunt
    private Returned returned;

}
