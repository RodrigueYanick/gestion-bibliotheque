package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visitor")
public class Visitor extends User{

    @Column(name = "statut",nullable = false)
    private boolean statut;

}