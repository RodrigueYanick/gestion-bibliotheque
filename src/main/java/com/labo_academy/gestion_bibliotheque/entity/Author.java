package com.labo_academy.gestion_bibliotheque.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// creation de la table author
@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    @Column(nullable = false, length = 50)  // nom de l'auteur
    private String lastName;
    @Column(nullable = false, length = 50)  // prenom de l'auteur
    private String firstName;
    @Column(nullable = false, unique = true, length = 50)  // immatricution de l'auteur
    private String immatriculation;
    @Column(nullable = false, length = 50)  // nationalite de l'auteur
    private String nationality;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")  // mappage de author a document
    private List<Document> documents;

    // Relation avec Document
    @ManyToOne
    @JoinColumn(name = "documents_id")
    private Document document;

}
