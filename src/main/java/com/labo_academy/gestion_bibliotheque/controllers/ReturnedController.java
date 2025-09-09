package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceReturn.ReturnedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/returned")
public class ReturnedController {

    @Autowired
    private ReturnedService returnedService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ReturnedCreateDto returnedCreateDto){
        returnedService.create(returnedCreateDto);
        return ResponseEntity.ok(" creer avec succes");
    }

    @GetMapping("/")
    public List<ReturnedResponseDto> getAll(){
         return returnedService.findAll();    }

    @GetMapping("{id}")
    public ReturnedResponseDto getById(@PathVariable Long id){
        return returnedService.findById(id);    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        returnedService.delete(id);
    }
}
