package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceSanction.SanctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sanction")
public class SanctionController {

    @Autowired
    private SanctionService sanctionService;

    @PostMapping("/create")
    public ResponseEntity<SanctionResponseDto> create(@RequestBody SanctionCreateDto sanctionCreateDto){
        return new ResponseEntity<>(sanctionService.create(sanctionCreateDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<SanctionResponseDto>> getAll(){
        return ResponseEntity.ok(sanctionService.findAll());
    }

    @PutMapping("/update/{id}/{status}")
    public ResponseEntity<SanctionResponseDto> updateStatut(Long id, String status){
        return ResponseEntity.ok(sanctionService.updateStatus(id,status));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        sanctionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
