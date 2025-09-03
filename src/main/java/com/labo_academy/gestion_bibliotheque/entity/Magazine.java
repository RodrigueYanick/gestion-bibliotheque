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

// represente un magazine dans une bibliotheque
// contient des informations specifique a un magazine en plus des info du document
@Entity
@Table(name = "magazine")
@DiscriminatorValue("magazine")  // la valeur utiliser dans la colonne discriminante pour identifier ce type
@PrimaryKeyJoinColumn(name = "document_id")  // lie la cle primaire a celle de document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

public class Magazine extends Document {

    @Column(nullable = false, length = 20, unique = true)  // code ISSN du magazine
    private String issn;
    @Column(nullable = false)  // frequence de publication
    private int validationPeriod;

}
