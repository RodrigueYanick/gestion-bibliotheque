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

// represente un dictionnaire dans une bibliotheque
// contient des informations specifique a un dictionnaire en plus des info du document
@Entity
@Table(name = "dictionary")
@DiscriminatorValue("dictionary")
@PrimaryKeyJoinColumn(name = "document_id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)

public class Dictionary extends Document {

    @Column(length = 30, nullable = false)  // lanque du dictionnaire
    private String langue;
    @Column(name = "number_words", nullable = false)  // nombre de mots contenus
    private int numberWords;

}
