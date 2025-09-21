package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

// Représente un directeur dans la bibliothèque
// Hérite de la classe Users et ajoute un attribut spécifique (idNumber)
@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Table(name = "director")
public class Director extends Users {

    // Identifiant administratif du directeur
    @Column(name = "idNumber", nullable = false, length = 50)
    private String idNumber;

    // Getters/Setters 
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}