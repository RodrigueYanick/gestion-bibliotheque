package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceCategory.ServiceCategory;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private ServiceCategory serviceCategory;

    @PostMapping("/create")
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryCreateDto CategoryCreateDto){
        CategoryResponseDto createdCategory = serviceCategory.createCategory(CategoryCreateDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory(){
        return ResponseEntity.ok(serviceCategory.getAllCategory());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryResponseDto> update(@PathVariable Long id, @Valid @RequestBody CategoryCreateDto dto) {
        CategoryResponseDto updatedCategory = serviceCategory.update(id, dto);
        return ResponseEntity.ok(updatedCategory); // retourne 200 OK avec l'objet mis à jour
    }


    @GetMapping("{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(serviceCategory.getCategoryById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        serviceCategory.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
