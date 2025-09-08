package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)   // inclut les champs hérités de Users dans toString()
@Table(name = "librarian")
public class Librarian extends Users {

    // Attribut propre au bibliothécaire
    @Column(name = "idNumber", nullable = false, length = 50)
    private String idNumber;

    //getters/setters
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}