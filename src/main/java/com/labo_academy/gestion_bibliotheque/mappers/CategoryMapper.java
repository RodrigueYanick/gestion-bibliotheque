package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    // Conversion Entity To Dto
    public CategoryResponseDto fromEntityToDto(Category category){
        return  new CategoryResponseDto(
                category.getDescription(),
                category.getName()
        );
    }

    // conversion Dto To Entity
    public Category fromDtoToEntity(CategoryCreateDto categoryCreateDto){
        Category category = new Category();
        category.setDescription(categoryCreateDto.getDescription());
        category.setName(categoryCreateDto.getName());
        return category;
    }
}
