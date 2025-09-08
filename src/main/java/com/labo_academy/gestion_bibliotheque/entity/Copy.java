package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Représente une copie (exemplaire physique) d’un document
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identifiant unique de la copie
    private Long id;

    // Indique si la copie est actuellement empruntée ou non
    private boolean isBorrowed;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    // Relation N:1 → plusieurs copies appartiennent à un seul document
    private Document document;
}