package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceCopy.CopyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/copy")
@RequiredArgsConstructor
public class CopyController {

    private final CopyService copyService;

    // Creer une nouvelle copie
    @PostMapping("/create")
    public ResponseEntity<CopyResponseDto> createCopy(@Valid @RequestBody CopyCreateDto dto) {
        CopyResponseDto createdCopy = copyService.create(dto);
        return new ResponseEntity<>(createdCopy, HttpStatus.CREATED);
    }

    // Recuperer toutes les copies
    @GetMapping("/")
    public ResponseEntity<List<CopyResponseDto>> getAllCopies() {
        return ResponseEntity.ok(copyService.findAll());
    }

    // Recuperer une copie par son ID
    @GetMapping("/{id}")
    public ResponseEntity<CopyResponseDto> getCopyById(@PathVariable Long id) {
        return ResponseEntity.ok(copyService.findById(id));
    }

    // Recuperer toutes les copies d'un document via son matricule
    @GetMapping("/document/matricule/{matricule}")
    public ResponseEntity<List<CopyResponseDto>> getCopiesByDocumentMatricule(@PathVariable String matricule) {
        return ResponseEntity.ok(copyService.findByDocumentMatricule(matricule));
    }

    // Récuperer toutes les copies d’un document via son titre
    @GetMapping("/document/title/{title}")
    public ResponseEntity<List<CopyResponseDto>> getCopiesByDocumentTitle(@PathVariable String title) {
        return ResponseEntity.ok(copyService.findByDocumentTitle(title));
    }

    // Supprimer une copie par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCopy(@PathVariable Long id) {
        copyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
