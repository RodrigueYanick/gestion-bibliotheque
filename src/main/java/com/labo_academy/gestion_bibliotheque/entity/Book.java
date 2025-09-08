package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book")  
@DiscriminatorValue("book")  
// Utilisé dans une stratégie d’héritage avec table unique ou jointure
// Ici, "book" sera la valeur dans la colonne discriminante
@PrimaryKeyJoinColumn(name = "document_id")  
// Associe la clé primaire de Book à la clé primaire de Document
@Getter
@Setter
@ToString(callSuper = true) // Inclut aussi les attributs de Document dans le toString

public class Book extends Document {
    @Column(nullable = false, length = 20, unique = true)  
    // Colonne "isbn" : identifiant unique du livre, max 20 caractères
    private String isbn;

    @Column(nullable = false, name = "number_pages")  
    // Colonne "number_pages" : nombre total de pages du livre (obligatoire)
    private int numberPages;

    // Getters et setters explicites (Lombok les génère déjà avec @Getter et @Setter,
    // donc ils ne sont pas nécessaires, mais tu les as définis pour plus de clarté)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

}
