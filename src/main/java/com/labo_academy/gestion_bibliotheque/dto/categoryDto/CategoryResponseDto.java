package com.labo_academy.gestion_bibliotheque.dto.categoryDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter

public class CategoryResponseDto {

    private String description;
    private String name;

    // Constructeur
    public CategoryResponseDto(String description, String name) {
        this.description = description;
        this.name = name;
    }

    // Getters abnd Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
