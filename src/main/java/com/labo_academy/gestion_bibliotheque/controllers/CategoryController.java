package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryResponseDto;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceCategory.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ServiceCategory serviceCategory;

    @PostMapping("/create")
    public ResponseEntity<String> createcategory(@RequestBody CategoryCreateDto categoryCreateDto){
        serviceCategory.createCategory(categoryCreateDto);
        return ResponseEntity.ok("Category creer avec succes");
    }


    @GetMapping("/")
    public List<CategoryResponseDto> getAllCategory(){
        return serviceCategory.getAllCategory();
    }

    @PutMapping("/update/{id}/{category}")
    public CategoryResponseDto update(Long id, CategoryCreateDto dto){
        return serviceCategory.update(id,dto);
    }

    @GetMapping("{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Long id){
        return serviceCategory.getCategoryById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        serviceCategory.deleteById(id);
    }
}
