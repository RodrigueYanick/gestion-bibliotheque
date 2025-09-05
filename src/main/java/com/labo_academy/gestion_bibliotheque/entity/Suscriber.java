package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Table(name = "suscriber")
public class Suscriber extends Users {

    //Attributs propres a la classe

    @Column(name = "accountNumber", nullable = false,length = 2255)
    private Long accountNumber;

    @Column(name = "statut",nullable = false)
    private boolean statut;

    // Relation avec Reservation
    @OneToMany(mappedBy = "abonne",fetch = FetchType.LAZY)
    private List<Reservation> reservations ;

    //Relation avec Emprunt-abonnee
    @OneToMany(mappedBy = "suscriber",fetch = FetchType.LAZY)
    private List<Borrow> borrows ;
}
