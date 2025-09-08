package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyResponseDto;
import com.labo_academy.gestion_bibliotheque.repository.CopyRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceCopy.ServiceCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/copy")
public class CopyController {

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private ServiceCopy serviceCopy;

    @PostMapping("/create")
    public ResponseEntity<String> createCopy(@RequestBody CopyCreateDto copyCreateDto){
        serviceCopy.createCopy(copyCreateDto);
        return ResponseEntity.ok("Copy creer avec succes");
    }


    @GetMapping("/")
    public List<CopyResponseDto> getAllCopy(){
        return serviceCopy.getAllCopy();
    }

    @GetMapping("/update/{id}/{copy}")
    public CopyResponseDto update(Long id, CopyCreateDto dto){
        return serviceCopy.update(id,dto);
    }

    @GetMapping("{id}")
    public CopyResponseDto getCopyById(@PathVariable Long id){
        return serviceCopy.getCopyById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        serviceCopy.deleteById(id);
    }

}
