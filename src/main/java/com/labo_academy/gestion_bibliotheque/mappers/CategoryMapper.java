package com.labo_academy.gestion_bibliotheque.mappers;

import org.springframework.stereotype.Component;

import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Category;

@Component
public class CategoryMapper {

    // Convertir Entity → ResponseDto
    public CategoryResponseDto toDto(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryResponseDto(
                category.getCategoryId(),
                category.getDescription(),
                category.getName()
        );
    }

    // Convertir CreateDto → Entity
    public Category toEntity(CategoryCreateDto dto) {
        if (dto == null) {
            return null;
        }
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }
}
