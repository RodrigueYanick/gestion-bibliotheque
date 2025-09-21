package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceReturn.ReturnedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/returned")
public class ReturnedController {

    @Autowired
    private ReturnedService returnedService;

    @PostMapping("/create")
    public ResponseEntity<ReturnedResponseDto> create(@RequestBody ReturnedCreateDto returnedCreateDto){
        return new ResponseEntity<>(returnedService.create(returnedCreateDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ReturnedResponseDto>> getAll(){
         return ResponseEntity.ok(returnedService.findAll());    
    }

    @GetMapping("{id}")
    public ResponseEntity<ReturnedResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(returnedService.findById(id));    
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        returnedService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
