package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    // Date d'enregistrement de la réservation
    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;

    // Statut de la réservation (status ou annulée)
    @Column(nullable = false)
    private boolean active;

    // Relations avec l'abonné (plusieurs réservations possibles pour un abonné)
    @ManyToOne
    @JoinColumn(name = "subscriber_id", nullable = false)
    private LibraryClient subscriber;

    // Relations avec un document (plusieurs réservations possibles pour un document)
    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    // Initialisation automatique de la date
    @PrePersist
    private void prePersist() {
        reservationDate = LocalDate.now();
    }

    // Constructeurs
    public Reservation() {}

    public Reservation(Long reservationId, LocalDate reservationDate, boolean active) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.active = active;
    }
}
