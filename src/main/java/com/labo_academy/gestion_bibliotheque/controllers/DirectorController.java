package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurResponseDto;
import com.labo_academy.gestion_bibliotheque.repository.DirectorRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceDirector.ServiceDirector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/director")
public class DirectorController {

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private ServiceDirector serviceDirector;

    @PostMapping("/create")
    public ResponseEntity<String> createDirector(@RequestBody DirecteurCreateDto directeurCreateDto){
        serviceDirector.createDirecteur(directeurCreateDto);
        return ResponseEntity.ok("Directeur creer avec succes");
    }

    @GetMapping("/")
    public List<DirecteurResponseDto> getAllDirecteur(){
        return serviceDirector.getAllDirecteur();
    }

    @PutMapping("/update/{id}/{director}")
    public DirecteurResponseDto update(Long id, DirecteurCreateDto dto){
        return serviceDirector.update(id,dto);
    }

    @GetMapping("{id}")
    public DirecteurResponseDto getDirecteurById(@PathVariable Long id){
        return serviceDirector.getDirecteurById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        serviceDirector.deleteById(id);
    }
}
