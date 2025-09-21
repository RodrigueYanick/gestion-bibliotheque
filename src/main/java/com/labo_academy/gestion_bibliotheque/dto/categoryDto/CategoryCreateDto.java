package com.labo_academy.gestion_bibliotheque.dto.categoryDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateDto {

    @Size(max = 255, message = "La description ne doit pas dépasser 255 caractères")
    private String description;

    @NotBlank(message = "Le nom de la catégorie est obligatoire")
    @Size(max = 100, message = "Le nom de la catégorie doit contenir au maximum 100 caractères")
    private String name;
}
