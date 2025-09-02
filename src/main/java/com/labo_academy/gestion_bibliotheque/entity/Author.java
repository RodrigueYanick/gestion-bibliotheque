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
    private String name;
    @Column(nullable = false, length = 50)  // prenom de l'auteur
    private String prename;
    @Column(nullable = false, unique = true, length = 50)  // immatricution de l'auteur
    private String immatriculation;
    @Column(nullable = false, length = 50)  // nationalite de l'auteur
    private String nationalite;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")  // mappage de author a document
    private List<Document> documents;

}
