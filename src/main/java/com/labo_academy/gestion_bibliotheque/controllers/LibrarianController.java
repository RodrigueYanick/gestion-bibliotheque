package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceLibrarian.ServiceLibrarian;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarian")
public class LibrarianController {

    private final ServiceLibrarian serviceLibrarian;

    public LibrarianController(ServiceLibrarian serviceLibrarian) {
        this.serviceLibrarian = serviceLibrarian;
    }

    @PostMapping("/create")
    public ResponseEntity<LibrarianResponseDto> createLibrarian(@Valid @RequestBody LibrarianCreateDto LibrarianCreateDto) {

        LibrarianResponseDto createdLibrarian = serviceLibrarian.createLibrarian(LibrarianCreateDto);
        return new ResponseEntity<>(createdLibrarian, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<LibrarianResponseDto>> getAllLibrarians() {
        List<LibrarianResponseDto> Librarians = serviceLibrarian.getAllLibrarian();
        return ResponseEntity.ok(Librarians);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibrarianResponseDto> getLibrarianById(@PathVariable Long id) {
        LibrarianResponseDto Librarian = serviceLibrarian.getLibrarianById(id);
        return ResponseEntity.ok(Librarian);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LibrarianResponseDto> updateLibrarian(
            @PathVariable Long id,
            @Valid @RequestBody LibrarianCreateDto dto) {

        // NE PAS encoder ici non plus — service gère l'encodage si nécessaire
        LibrarianResponseDto updatedLibrarian = serviceLibrarian.update(id, dto);
        return ResponseEntity.ok(updatedLibrarian);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLibrarian(@PathVariable long id) {
        serviceLibrarian.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
