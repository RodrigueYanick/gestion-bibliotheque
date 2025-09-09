package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceAuthor.ServiceAuthor;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorController {

    @Autowired
    private ServiceAuthor serviceAuthor;

    @PostMapping("/create")
    public ResponseEntity<AuthorResponseDto> createAuthor(@Valid @RequestBody AuthorCreateDto authorCreateDto){
        AuthorResponseDto createdAuthor = serviceAuthor.createAuthor(authorCreateDto);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthor(){
        return ResponseEntity.ok(serviceAuthor.getAllAuthor());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AuthorResponseDto> update(@PathVariable Long id, @Valid @RequestBody AuthorCreateDto dto) {
        AuthorResponseDto updatedAuthor = serviceAuthor.update(id, dto);
        return ResponseEntity.ok(updatedAuthor); // retourne 200 OK avec l'objet mis à jour
    }


    @GetMapping("{id}")
    public ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable Long id){
        return ResponseEntity.ok(serviceAuthor.getAuthorById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        serviceAuthor.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
