package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientResponseDto;
import com.labo_academy.gestion_bibliotheque.services.servicelibraryClient.LibraryClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libraryClient")
public class LibraryClientController {

    @Autowired
    private LibraryClientService libraryClientService;

    @PostMapping("/create")
    public ResponseEntity<LibraryClientResponseDto> createClient(@RequestBody LibraryClientCreateDto libraryClientCreateDto){
        LibraryClientResponseDto libraryClient = libraryClientService.create(libraryClientCreateDto);
        return new ResponseEntity<>(libraryClient, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<LibraryClientResponseDto>> getAllClient(){
        return ResponseEntity.ok(libraryClientService.findAll());
    }

    @PutMapping("/update/{id}/{client}")
    public ResponseEntity<LibraryClientResponseDto> update(@PathVariable Long id, @RequestBody LibraryClientCreateDto dto){
        return ResponseEntity.ok(libraryClientService.update(id,dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryClientResponseDto> getClientById(@PathVariable Long id){
        return ResponseEntity.ok(libraryClientService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        libraryClientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/upgrade/{id}/{account}")
    public ResponseEntity<LibraryClientResponseDto> upgradeToSubscriber(@PathVariable Long id, @PathVariable String accountNumber){
        return ResponseEntity.ok(libraryClientService.upgradeToSubscriber(id, accountNumber));
    }

}
