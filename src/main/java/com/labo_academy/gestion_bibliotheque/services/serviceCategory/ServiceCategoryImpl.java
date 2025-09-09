package com.labo_academy.gestion_bibliotheque.services.serviceCategory;

import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.mappers.CategoryMapper;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

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
        List<Category> categoryList = categoryRepository.findAll();
        if(categoryList.isEmpty()){throw new RuntimeException("Aucune category trouver.");}
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for (Category category : categoryList) {
            categoryResponseDtos.add(categoryMapper.toDto(category));
        }
        return categoryResponseDtos;     }

    @Override
    public CategoryResponseDto getCategoryById(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category introuvable"));
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryCreateDto dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categorie non trouvé avec l’ID : " + id));
        category.setDescription(dto.getDescription());
        category.setName(dto.getName());
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public boolean existsById(long id) {
        return categoryRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!categoryRepository.existsById(id)){
            throw new RuntimeException("la categirie n'existe pas");
        }
        categoryRepository.deleteById(id);
    }
}
