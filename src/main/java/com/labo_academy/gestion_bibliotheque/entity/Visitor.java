package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
// @NoArgsConstructor
@Table(name = "visitor")
public class Visitor extends Users {

    @Column(name = "statut",nullable = false)
    private boolean statut;

    // Constructeur
    public Visitor(Long id, String lastName, String firstName, LocalDate birthDate, String password, String email, String address, Role role, byte[] image, LocalDate creationDate, Date lastUpdate, boolean isDelete,boolean statut) {
        super(id, lastName, firstName, birthDate, password, email, address, role, image, creationDate, lastUpdate, isDelete);
        this.statut = statut;
    }

    public Visitor() {
        super();
    }

    // Getters and Setters
    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
}