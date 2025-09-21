package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "library_client")
@Getter
@Setter
@ToString(callSuper = true, exclude = {"borrows"})
public class LibraryClient extends Users {

    @Enumerated(EnumType.STRING)
    @Column(name = "role_client", nullable = false, length = 20)
    private RoleClient roleClient = RoleClient.VISITOR; // Par defaut, un client est visiteur

    // -------- Champs specifiques aux abonnes --------
    @Column(name = "account_number", unique = true, length = 50)
    private String accountNumber; // Null tant que VISITOR

    @Column(name = "subscriber_status")
    private Boolean subscriberStatus; // true si abonne actif

    // -------- Champs spwcifiques aux visiteurs --------
    @Column(name = "visitor_status")
    private Boolean visitorStatus = true; // true par défaut a la création

    @OneToMany(mappedBy = "subscriber", fetch = FetchType.LAZY)
    private List<Borrow> borrows;

    // -------- Méthodes metiers --------

    
    // Passer d’un VISITOR à un SUBSCRIBER
    
    public void upgradeToSubscriber(String accountNumber) {
        this.roleClient = RoleClient.SUBSCRIBER;
        this.accountNumber = accountNumber;
        this.subscriberStatus = true;
        this.visitorStatus = null; // inutile une fois abonné
    }

    
    // Revenir à un VISITOR
    
    public void downgradeToVisitor() {
        this.roleClient = RoleClient.VISITOR;
        this.accountNumber = null;
        this.subscriberStatus = null;
        this.visitorStatus = true;
    }
}
