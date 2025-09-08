package com.labo_academy.gestion_bibliotheque.services.serviceCategory;

import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryResponseDto;

import java.util.List;

public interface ServiceCategory {

    // CRUD category
    public CategoryResponseDto createCategory(CategoryCreateDto categoryCreateDto);
    public List<CategoryResponseDto> getAllCategory();
    public CategoryResponseDto getCategoryById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
