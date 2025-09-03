package com.labo_academy.gestion_bibliotheque.dto.documentDto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumetCreateDto {

    @NotBlank(message = "le titre est obligatoire")
    @Size(max = 100, message = "la taille du titre doit etre inferieur a 100 caractere")
    private String title;
    @NotBlank(message = "la quantite est obligatoire")
    @Size(min = 1, message = "valeur minimale c'est 1")
    private int quantity;
    @NotBlank(message = "la date de publication est obligatoire")
    
    private LocalDate publicationDate;
    private boolean isDeleted;
    private byte[] image;
    private String publisher;

}
