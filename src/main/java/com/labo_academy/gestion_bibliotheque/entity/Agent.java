package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Table(name = "agent")
public class Agent extends Users {

    // Definition des attributs Propres

    @Column(name = "idNumber", nullable = false, unique = true, length = 50)  // ajout des contrainte

    private String idNumber; // Attribut qui représente le numéro d'identification

    //permet de récupérer la valeur de idNumber
    public String getIdNumber() {
        return idNumber;
    }

    //permet de changer la valeur de idNumber
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
