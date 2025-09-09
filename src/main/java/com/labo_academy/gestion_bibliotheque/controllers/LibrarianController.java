package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceLibrarian.ServiceLibrarian;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/librarian")
public class LibrarianController {

    @Autowired
    private ServiceLibrarian serviceLibrarian;

    @PostMapping("/create")
    public ResponseEntity<LibrarianResponseDto> createLibrarian(@Valid @RequestBody LibrarianCreateDto LibrarianCreateDto){
        LibrarianResponseDto createdLibrarian = serviceLibrarian.createLibrarian(LibrarianCreateDto);
        return new ResponseEntity<>(createdLibrarian, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<LibrarianResponseDto>> getAllLibrarian(){
        return ResponseEntity.ok(serviceLibrarian.getAllLibrarian());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LibrarianResponseDto> update(@PathVariable Long id, @Valid @RequestBody LibrarianCreateDto dto) {
        LibrarianResponseDto updatedLibrarian = serviceLibrarian.update(id, dto);
        return ResponseEntity.ok(updatedLibrarian);
    }


    @GetMapping("{id}")
    public ResponseEntity<LibrarianResponseDto> getLibrarianById(@PathVariable Long id){
        return ResponseEntity.ok(serviceLibrarian.getLibrarianById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        serviceLibrarian.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
