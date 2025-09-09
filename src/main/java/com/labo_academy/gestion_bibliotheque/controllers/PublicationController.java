package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationResponseDto;
import com.labo_academy.gestion_bibliotheque.services.servicePublication.ServicePublication;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Publication")
public class PublicationController {

    @Autowired
    private ServicePublication servicePublication;

    @PostMapping("/create")
    public ResponseEntity<PublicationResponseDto> createPublication(@Valid @RequestBody PublicationCreateDto PublicationCreateDto){
        PublicationResponseDto createdPublication = servicePublication.createPublication(PublicationCreateDto);
        return new ResponseEntity<>(createdPublication, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<PublicationResponseDto>> getAllPublication(){
        return ResponseEntity.ok(servicePublication.getAllPublication());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PublicationResponseDto> update(@PathVariable Long id, @Valid @RequestBody PublicationCreateDto dto) {
        PublicationResponseDto updatedPublication = servicePublication.update(id, dto);
        return ResponseEntity.ok(updatedPublication); // retourne 200 OK avec l'objet mis à jour
    }


    @GetMapping("{id}")
    public ResponseEntity<PublicationResponseDto> getPublicationById(@PathVariable Long id){
        return ResponseEntity.ok(servicePublication.getPublicationById(id));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        servicePublication.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
