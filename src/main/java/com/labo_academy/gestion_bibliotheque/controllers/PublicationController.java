package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationResponseDto;
import com.labo_academy.gestion_bibliotheque.services.servicePublication.ServicePublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/publication")
public class PublicationController {

    @Autowired
    private ServicePublication servicePublication;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody PublicationCreateDto publicationCreateDto){
        servicePublication.createPublication(publicationCreateDto);
        return ResponseEntity.ok("Publication creer avec succes");
    }

    @GetMapping("/")
    public List<PublicationResponseDto> getAllPublication(){
        return servicePublication.getAllPublication();
    }

    @PutMapping("/update/{id}/{director}")
    public PublicationResponseDto update(Long id, PublicationCreateDto dto){
        return servicePublication.update(id,dto);
    }

    @GetMapping("{id}")
    public PublicationResponseDto getDirecteurById(@PathVariable Long id){
return servicePublication.getPublicationById(id);    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        servicePublication.deleteById(id);
    }
}
