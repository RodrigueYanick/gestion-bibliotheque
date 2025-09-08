package com.labo_academy.gestion_bibliotheque.dto.categoryDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {

    private Long id;          // identifiant unique
    private String description;
    private String name;
}
