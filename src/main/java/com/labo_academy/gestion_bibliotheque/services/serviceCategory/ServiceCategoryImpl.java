package com.labo_academy.gestion_bibliotheque.services.serviceCategory;

import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.mappers.CategoryMapper;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceCategoryImpl implements ServiceCategory{

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDto createCategory(CategoryCreateDto categoryCreateDto) {
        Category category = categoryMapper.toEntity(categoryCreateDto);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto getCategoryById(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category introuvable"));
        return categoryMapper.toDto(category);
    }

    @Override
    public boolean existsById(long id) {
        return categoryRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!categoryRepository.existsById(id)){
            System.out.println("la categirie n'existe pas");
        }
        categoryRepository.deleteById(id);
    }
}
