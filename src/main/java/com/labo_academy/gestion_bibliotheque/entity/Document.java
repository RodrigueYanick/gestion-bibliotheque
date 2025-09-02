package com.labo_academy.gestion_bibliotheque.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Classe abstraite represantant un un document dans une bibliotheque
// utilise l'heritage JPA avec pour strategie JOINED

@Entity  // permet de dire a spring que il sagit d'une table dans la base de donnee
@Inheritance(strategy = InheritanceType.JOINED)  // les sous classe aurons leur propre table lie a la classe mere par la cle primaire
@DiscriminatorColumn(name = "document_type", length = 50)  // aide a l'dentification du type de document dans la base de donnee
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "document")

public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // pour generer automatiquement les identifiant unique
    private Long id;
    @Column(nullable = false, length = 100)  // titre du document obligatoire
    private String title;
    @Column(nullable = false)  // quantite disponible en stock
    private int quantity;
    @Column(nullable = false, name = "publication_date")  // date de publication du document
    private LocalDate publicationDate;
    @Column(nullable = false, name = "creation_date")  // date de creation du document
    private LocalDate creationDate;
    @Column(nullable = false, name = "last_update_date")  // derniere date de mise a jour 
    private LocalDate lastUpdateDate;
    @Column(nullable = false, name = "is_deleted")  // element logique pour la suppression
    private boolean isDeleted;
    @Lob  // perment de stocker des donnee binaire volumineuses(image)
    @Column(nullable = false)
    private byte[] image;

    // methode appele automatiquement avant la persistance initiale
    @PrePersist
    protected void onCreate(){
        this.creationDate = LocalDate.now();
        this.lastUpdateDate = LocalDate.now();
    }

    // methode appele automatiqument avant chaque mise a jour
    @PreUpdate
    protected void onUpdate(){
        this.lastUpdateDate = LocalDate.now();
    }

}
