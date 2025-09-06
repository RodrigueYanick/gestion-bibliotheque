package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    CategoryRepository categoryRepository;
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
        categoryRepository.findByName(categoryCreateDto.getName());
        return category;
    }
}
