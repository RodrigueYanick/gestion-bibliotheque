package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "agent")
public class Agent extends Users {

    // Definition des attributs Propres

    @Column(name = "idNumber", nullable = false, unique = true, length = 50)
    private String idNumber;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
