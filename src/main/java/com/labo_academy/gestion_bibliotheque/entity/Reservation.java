package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {

    // Attributs

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Column(name = "reservationDate", nullable = false,length = 50)
    private LocalDate reservationDate;

    @Column(name = "statut", nullable = false,length = 50)
    private boolean statut;

    @PrePersist
    private void prepersist(){
        reservationDate = LocalDate.now();
    }

    // Relations avec Abonne-reservation
    @ManyToOne
    @JoinColumn(name = "abonne_id",nullable = false)
    private Suscriber abonne;

    // Relation avec Document-reservation
    @ManyToOne
    @JoinColumn(name = "document_id",nullable = false)
    private Document documents;
}