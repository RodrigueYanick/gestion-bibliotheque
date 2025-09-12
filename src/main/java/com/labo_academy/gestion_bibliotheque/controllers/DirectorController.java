package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.directorDto.DirectorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.directorDto.DirectorResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceDirector.ServiceDirector;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/director")
public class DirectorController {

    private final ServiceDirector serviceDirector;

    public DirectorController(ServiceDirector serviceDirector) {
        this.serviceDirector = serviceDirector;
    }

    @PostMapping("/create")
    public ResponseEntity<DirectorResponseDto> createDirector(@Valid @RequestBody DirectorCreateDto directorCreateDto) {

        DirectorResponseDto createdDirector = serviceDirector.createDirector(directorCreateDto);
        return new ResponseEntity<>(createdDirector, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<DirectorResponseDto>> getAllDirectors() {
        List<DirectorResponseDto> directors = serviceDirector.getAllDirector();
        return ResponseEntity.ok(directors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorResponseDto> getDirectorById(@PathVariable Long id) {
        DirectorResponseDto director = serviceDirector.getDirectorById(id);
        return ResponseEntity.ok(director);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DirectorResponseDto> updateDirector(
            @PathVariable Long id,
            @Valid @RequestBody DirectorCreateDto dto) {

        // NE PAS encoder ici non plus — service gère l'encodage si nécessaire
        DirectorResponseDto updatedDirector = serviceDirector.update(id, dto);
        return ResponseEntity.ok(updatedDirector);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable long id) {
        serviceDirector.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
