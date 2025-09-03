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
@Table(name = "librarian")
public class Librarian extends Users {

    // Attributs Propres

    @Column(name = "idNumber",nullable = false,length = 255)
    private String idNumber;

}