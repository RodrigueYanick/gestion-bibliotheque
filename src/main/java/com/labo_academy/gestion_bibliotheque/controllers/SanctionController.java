package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceSanction.SanctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sanction")
public class SanctionController {

    @Autowired
    private SanctionService sanctionService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody SanctionCreateDto sanctionCreateDto){
        sanctionService.create(sanctionCreateDto);
        return ResponseEntity.ok("Sanction creer avec succes");
    }

    @GetMapping("/")
    public List<SanctionResponseDto> getAll(){
        return sanctionService.findAll();
    }

    @PutMapping("/update/{id}/{status}")
    public SanctionResponseDto updateStatut(Long id, String status){
        return sanctionService.updateStatus(id,status);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        sanctionService.delete(id);
    }
}
