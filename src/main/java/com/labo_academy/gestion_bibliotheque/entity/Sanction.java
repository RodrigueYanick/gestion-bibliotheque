package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// creation de la table sanction
@Entity
@Table(name = "sanction")
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "sanction")  // relation entre une sanction et un emprunt
    private Borrow borrow;

}
