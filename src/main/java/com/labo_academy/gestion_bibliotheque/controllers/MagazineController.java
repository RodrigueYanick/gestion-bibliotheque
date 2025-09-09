package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceMagazine.ServiceMagazine;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/magazine")
public class MagazineController {

    @Autowired
    private ServiceMagazine serviceMagazine;

    @PostMapping("/create")
    public ResponseEntity<MagazineResponseDto> createMagazine(@Valid @RequestBody MagazineCreateDto MagazineCreateDto){
        MagazineResponseDto createdMagazine = serviceMagazine.createMagazine(MagazineCreateDto);
        return new ResponseEntity<>(createdMagazine, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<MagazineResponseDto>> getAllMagazine(){
        return ResponseEntity.ok(serviceMagazine.getAllMagazine());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MagazineResponseDto> update(@PathVariable Long id, @Valid @RequestBody MagazineCreateDto dto) {
        MagazineResponseDto updatedMagazine = serviceMagazine.update(id, dto);
        return ResponseEntity.ok(updatedMagazine); // retourne 200 OK avec l'objet mis à jour
    }


    @GetMapping("{id}")
    public ResponseEntity<MagazineResponseDto> getMagazineById(@PathVariable Long id){
        return ResponseEntity.ok(serviceMagazine.getMagazineById(id));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        serviceMagazine.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
