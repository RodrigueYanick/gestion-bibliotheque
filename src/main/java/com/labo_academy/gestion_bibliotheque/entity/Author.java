package com.labo_academy.gestion_bibliotheque.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// creation de la table author
// Définition de la classe comme une entité JPA
@Entity
@Table(name = "author")  // Le nom de la table dans la base sera "author"
@Getter  // Génère automatiquement les getters (via Lombok)
@Setter  // Génère automatiquement les setters (via Lombok)


public class Author {

    @Id  // Indique la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Génération auto-incrémentée (IDENTITY = prise en charge par la BDD)
    private Long authorId;

    @Column(nullable = false, length = 50)  // Colonne "lastName", obligatoire, max 50 caractères
    private String lastName;

    @Column(nullable = false, length = 50)  // Colonne "firstName", obligatoire, max 50 caractères
    private String firstName;

    @Column(nullable = false, unique = true, length = 50)  // Colonne "immatriculation" : obligatoire, unique, max 50 caractères
    private String immatriculation;

    @Column(nullable = false, length = 50)  // Colonne "nationality", obligatoire, max 50 caractères
    private String nationality;

    // Constructeur par défaut
    public Author() {}

    // Constructeur avec tous les champs principaux
    public Author(Long authorId, String lastName, String firstName, String immatriculation, String nationality) {
        this.authorId = authorId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.immatriculation = immatriculation;
        this.nationality = nationality;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")  
    // Relation 1:N (un auteur peut avoir plusieurs documents)
    // - fetch = LAZY : les documents ne seront chargés que lorsqu'on les appelle
    // - mappedBy = "author" : fait référence à l'attribut "author" dans la classe Document
    private List<Document> documents;

}
