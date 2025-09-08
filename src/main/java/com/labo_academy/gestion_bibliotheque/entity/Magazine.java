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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "magazine")
@DiscriminatorValue("magazine")
@PrimaryKeyJoinColumn(name = "document_id")
@Getter
@Setter
@ToString(callSuper = true)
public class Magazine extends Document {

    // Code ISSN (unique pour chaque magazine)
    @Column(nullable = false, unique = true, length = 20)
    private String issn;

    // Fréquence de publication (ex: nombre de jours/semaines entre 2 éditions)
    @Column(nullable = false)
    private int publicationFrequency;

 
}