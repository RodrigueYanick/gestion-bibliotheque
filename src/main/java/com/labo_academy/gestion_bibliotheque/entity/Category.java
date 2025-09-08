package com.labo_academy.gestion_bibliotheque.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// Représente une catégorie de documents dans la bibliothèque
@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Clé primaire auto-incrémentée
    private Long categoryId;

    @Column(nullable = false, length = 50)  
    // Nom de la catégorie (ex: "Roman", "Science", "Histoire")
    private String name;

    @Column(nullable = false, length = 250)  
    // Brève description de la catégorie
    private String description;

    // Constructeurs
    public Category() {}

    public Category(Long categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    // donc ceux que tu as écrits manuellement sont redondants.

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    // Relation 1:N : une catégorie peut contenir plusieurs documents
    // - fetch = LAZY : les documents ne sont chargés que sur demande
    // - mappedBy = "category" → fait référence à l’attribut "category" dans l’entité Document
    private List<Document> documents;
}