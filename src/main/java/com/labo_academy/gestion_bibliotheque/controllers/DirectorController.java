package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.directorDto.DirectorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.directorDto.DirectorResponseDto;
import com.labo_academy.gestion_bibliotheque.repository.DirectorRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceDirector.ServiceDirector;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/director")
public class DirectorController {

    @Autowired
    private DirectorRepository DirectorRepository;

    @Autowired
    private ServiceDirector serviceDirector;

    @PostMapping("/create")
    public ResponseEntity<DirectorResponseDto> createDirector(@Valid @RequestBody DirectorCreateDto DirectorCreateDto){
        DirectorResponseDto createdDirector = serviceDirector.createDirecteur(DirectorCreateDto);
        return new ResponseEntity<>(createdDirector, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<DirectorResponseDto>> getAllDirector(){
        return ResponseEntity.ok(serviceDirector.getAllDirecteur());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DirectorResponseDto> update(@PathVariable Long id, @Valid @RequestBody DirectorCreateDto dto) {
        DirectorResponseDto updatedDirector = serviceDirector.update(id, dto);
        return ResponseEntity.ok(updatedDirector); // retourne 200 OK avec l'objet mis à jour
    }


    @GetMapping("{id}")
    public ResponseEntity<DirectorResponseDto> getDirectorById(@PathVariable Long id){
        return ResponseEntity.ok(serviceDirector.getDirecteurById(id));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        serviceDirector.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
