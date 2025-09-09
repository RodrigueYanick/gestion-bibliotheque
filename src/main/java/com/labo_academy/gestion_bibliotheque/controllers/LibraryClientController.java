package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientResponseDto;
import com.labo_academy.gestion_bibliotheque.services.servicelibraryClient.LibraryClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libraryClient")
public class LibraryClientController {

    @Autowired
    private LibraryClientService libraryClientService;

    @PostMapping("/create")
    public ResponseEntity<String> createClient(@RequestBody LibraryClientCreateDto libraryClientCreateDto){
        libraryClientService.create(libraryClientCreateDto);
        return ResponseEntity.ok("Client creer avec succes");
    }

    @GetMapping("/")
    public List<LibraryClientResponseDto> getAllClient(){

        return libraryClientService.findAll();
    }

    @PutMapping("/update/{id}/{client}")
    public LibraryClientResponseDto update(Long id, LibraryClientCreateDto dto){
        return libraryClientService.update(id,dto);
    }

    @GetMapping("{id}")
    public LibraryClientResponseDto getClientById(@PathVariable Long id){
        return libraryClientService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){

        libraryClientService.delete(id);
    }
}
