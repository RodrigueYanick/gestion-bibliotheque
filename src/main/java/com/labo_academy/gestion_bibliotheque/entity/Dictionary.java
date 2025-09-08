package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Représente un dictionnaire dans la bibliothèque
// Hérite de Document et ajoute des attributs spécifiques (langue, nombre de mots)
@Entity
@Table(name = "dictionary")
@DiscriminatorValue("dictionary")  
// Valeur utilisée dans la colonne discriminante pour identifier ce type
@PrimaryKeyJoinColumn(name = "document_id")  
// La clé primaire est jointe à celle de Document
@Getter
@Setter
@ToString(callSuper = true) // Inclut aussi les infos héritées de Document
public class Dictionary extends Document {

    @Column(length = 30, nullable = false)  
    // Langue du dictionnaire (ex: "Français", "Anglais")
    private String language;

    @Column(name = "number_words", nullable = false)  
    // Nombre de mots contenus dans le dictionnaire
    private int numberWords;

    // getters et setters
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberWords() {
        return numberWords;
    }

    public void setNumberWords(int numberWords) {
        this.numberWords = numberWords;
    }
}