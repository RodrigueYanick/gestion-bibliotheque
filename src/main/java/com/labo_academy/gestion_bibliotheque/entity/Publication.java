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
@Table(name = "publication")
@Getter
@Setter
@DiscriminatorValue("publication")
@PrimaryKeyJoinColumn(name = "document_id")
@ToString(callSuper = true)
public class Publication extends Document {

    // Université d'origine de la publication
    @Column(length = 100, nullable = false)
    private String university;

    // Constructeurs
    public Publication() {
        super();
    }

    public Publication(String university) {
        this.university = university;
    }
}