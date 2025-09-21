package com.labo_academy.gestion_bibliotheque.dto.documentDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentCreateDto {

    @NotBlank(message = "Le titre est obligatoire")
    @Size(max = 100, message = "La taille du titre doit être inférieure à 100 caractères")
    private String title;

    @NotNull(message = "La date de publication est obligatoire")
    @PastOrPresent(message = "La date de publication ne peut pas être dans le futur")
    private LocalDate publicationDate;

    @NotBlank(message = "La maison d’édition est obligatoire")
    private String publisher;

    @NotBlank(message = "La catégorie est obligatoire")
    private String categoryName;

    @NotBlank(message = "L’auteur est obligatoire")
    private String immatriculation;

}
