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

// represente une publication dans une bibliotheque
// contient des informations specifique a une publication en plus des info du document
@Entity
@Table(name = "publication")
@Getter
@Setter
@DiscriminatorValue("publication")
@PrimaryKeyJoinColumn(name = "document_id")
@ToString(callSuper = true)

public class Publication extends Document {

    @Column(length = 100, nullable = false)  // universite d'origine de la publication
    private String university;

    // constructeur
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
