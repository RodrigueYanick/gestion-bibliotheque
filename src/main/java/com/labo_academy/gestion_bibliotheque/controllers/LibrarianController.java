package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianResponseDto;
import com.labo_academy.gestion_bibliotheque.repository.LibrarianRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceLibrarian.ServiceLibrarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/librarian")
public class LibrarianController {

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private ServiceLibrarian serviceLibrarian;

    @PostMapping("/create")
    public ResponseEntity<String> createLibrarian(@RequestBody LibrarianCreateDto librarianCreateDto){
        serviceLibrarian.createLibrarian(librarianCreateDto);
        return ResponseEntity.ok("Librarian creer avec succes");
    }

    @GetMapping("/")
    public List<LibrarianResponseDto> getAllLibrarian(){
       return serviceLibrarian.getAllLibrarian();
    }

    @PutMapping("/update/{id}/{director}")
    public LibrarianResponseDto update(Long id, LibrarianCreateDto dto){
        return serviceLibrarian.update(id,dto);
    }

    @GetMapping("{id}")
    public LibrarianResponseDto getLibrarianById(@PathVariable Long id){
        return serviceLibrarian.getLibrarianById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        serviceLibrarian.deleteById(id);
    }

}
