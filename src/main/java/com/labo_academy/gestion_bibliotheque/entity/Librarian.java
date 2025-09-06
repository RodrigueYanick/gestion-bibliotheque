package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Table(name = "librarian")
public class Librarian extends Users {

    // Attributs Propres

    @Column(name = "idNumber",nullable = false,length = 50)
    private String idNumber;

    // Getters and Setters
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}