package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceMagazine.ServiceMagazine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/magazine")
public class MagazineController {

    @Autowired
    private ServiceMagazine serviceMagazine;

    @PostMapping("/create")
    public ResponseEntity<Void> createMagazine(@RequestBody MagazineCreateDto magazineCreateDto){
         serviceMagazine.createMagazine(magazineCreateDto);
         ResponseEntity.ok("Magazine creer avec succes");
        return null;
    }

    @GetMapping("/")
    public List<MagazineResponseDto> getAllMagazine(){
        return serviceMagazine.getAllMagazine();
    }

    @PutMapping("/update/{id}/{magazine}")
    public MagazineResponseDto update(Long id, MagazineCreateDto dto){

        return serviceMagazine.update(id,dto);
    }

    @GetMapping("{id}")
    public MagazineResponseDto getById(@PathVariable Long id){
        return serviceMagazine.getMagazineById(id);}

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        serviceMagazine.deleteById(id);
    }
}
