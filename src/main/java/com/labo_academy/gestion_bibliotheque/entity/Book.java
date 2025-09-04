package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// represente un livre dans une bibliotheque
// herite de Document et augmente des attributs specifique a un livre
@Entity
@Table(name = "book")
@DiscriminatorValue("book")  // la valeur utiliser dans la colonne discriminante pour identifier ce type
@PrimaryKeyJoinColumn(name = "document_id")  // lie la cle primaire a celle de document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

public class Book extends Document {
    @Column(nullable = false, length = 20, unique = true)  // ISBN identifiant unique d'un livre
    private String isbn;
    @Column(nullable = false, name = "number_pages")  // nombre de page du livre
    private int numberPages;

    // Getters and Setters

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
