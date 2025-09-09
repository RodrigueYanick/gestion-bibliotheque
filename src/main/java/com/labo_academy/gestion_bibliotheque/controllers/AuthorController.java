package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorResponseDto;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceAuthor.ServiceAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ServiceAuthor serviceAuthor;

    @PostMapping("/create")
    public ResponseEntity<String> createAuthor(@RequestBody AuthorCreateDto authorCreateDto){
        serviceAuthor.createAuthor(authorCreateDto);
        return ResponseEntity.ok("Auteur creer avec succes");
    }


    @GetMapping("/")
    public List<AuthorResponseDto> getAllAuthor(){
        return serviceAuthor.getAllAuthor();
    }

    @PutMapping("/update/{id}/{author}")
    public AuthorResponseDto update(Long id, AuthorCreateDto dto){
        return serviceAuthor.update(id,dto);
    }

    @GetMapping("{id}")
    public AuthorResponseDto getAuthorById(@PathVariable Long id){
        return serviceAuthor.getAuthorById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        serviceAuthor.deleteById(id);
    }

}
