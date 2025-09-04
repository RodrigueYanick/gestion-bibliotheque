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

    // Constructor


    public Author() {

    }

    public Author(Long authorId, String lastName, String firstName, String immatriculation, String nationality) {
        this.authorId = authorId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.immatriculation = immatriculation;
        this.nationality = nationality;
    }

    // Getters and Setters
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")  // mappage de author a document
    private List<Document> documents;

    // Relation avec Document
    @ManyToOne
    @JoinColumn(name = "documents_id")
    private Document document;

}
