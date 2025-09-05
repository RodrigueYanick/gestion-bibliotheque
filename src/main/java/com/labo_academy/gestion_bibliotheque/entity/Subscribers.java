package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "suscriber")
public class Subscribers extends Users {
    
    //Attributs propres a la classe
    
    @Column(name = "accountNumber", nullable = false,length = 225)
    private Long accountNumber;
    
    @Column(name = "statut",nullable = false)
    private boolean statut;
    
    // Relation avec Reservation
    @OneToMany(mappedBy = "abonne",fetch = FetchType.LAZY)
    private List<Reservation> reservations ;
    
    //Relation avec Emprunt-abonnee
    @OneToMany(mappedBy = "suscriber",fetch = FetchType.LAZY)
    private List<Borrow> borrows ;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

}
