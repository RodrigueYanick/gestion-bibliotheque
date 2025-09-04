package com.labo_academy.gestion_bibliotheque.dto.documentDto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// @AllArgsConstructor
@NoArgsConstructor
public class DocumentCreateDto {

    @NotBlank(message = "le titre est obligatoire")
    @Size(max = 100, message = "la taille du titre doit etre inferieur a 100 caractere")
    private String title;
    @Min(value = 1, message = "valeur minimale c'est 1")
    private int quantity;
    @NotBlank(message = "la date de publication est obligatoire")
    @PastOrPresent(message = "la date de publication est obligatoire")
    private LocalDate publicationDate;
    @NotBlank(message = "ce statut est obligatoire")
    private boolean isDeleted;
    // @NotNull(message = "l'image est obligatoire")
    private byte[] image;
    
    @NotBlank(message = "la maison de publication est obligatoire")
    private String publisher;

    // Constructeur

    public DocumentCreateDto(String title, int quantity, LocalDate publicationDate, boolean isDeleted, byte[] image, String publisher) {
        this.title = title;
        this.quantity = quantity;
        this.publicationDate = publicationDate;
        this.isDeleted = isDeleted;
        this.image = image;
        this.publisher = publisher;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
