package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Table(name = "director")
public class Director extends Users {

    // Attributs propres

    @Column(name = "idNumber", nullable = false, length = 50)
    private String idNumber;

    // gETTERS AND sETTERS

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}