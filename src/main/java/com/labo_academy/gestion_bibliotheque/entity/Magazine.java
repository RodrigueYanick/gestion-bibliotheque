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

import java.time.LocalDate;
import java.util.List;

// represente un magazine dans une bibliotheque
// contient des informations specifique a un magazine en plus des info du document
@Entity
@Table(name = "magazine")
@DiscriminatorValue("magazine")  // la valeur utiliser dans la colonne discriminante pour identifier ce type
@PrimaryKeyJoinColumn(name = "document_id")  // lie la cle primaire a celle de document
@Getter
@Setter
@ToString(callSuper = true)

public class Magazine extends Document {

    @Column(nullable = false, length = 20, unique = true)  // code ISSN du magazine
    private String issn;
    @Column(nullable = false)  // frequence de publication
    private int validationPeriod;

// Contructeur


    public Magazine(Long id, String title, int quantity, LocalDate publicationDate, LocalDate creationDate, LocalDate lastUpdateDate, boolean isDeleted, byte[] image, String publisher, Category category, Author author, List<Borrow> borrows, List<Reservation> reservations,String issn,int validationPeriod) {
        super(id, title, quantity, publicationDate, creationDate, lastUpdateDate, isDeleted, image, publisher, category, author, borrows, reservations);
        this.issn = issn;
        this.validationPeriod = validationPeriod;
    }

    public Magazine() {
        super();
    }

    // Getters and Setters

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getValidationPeriod() {
        return validationPeriod;
    }

    public void setValidationPeriod(int validationPeriod) {
        this.validationPeriod = validationPeriod;
    }



}
