package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceDictionary.ServiceDictionary;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/Dictionary")
public class DictionaryController {

    @Autowired
    private ServiceDictionary serviceDictionary;

    @PostMapping("/create")
    public ResponseEntity<DictionaryResponseDto> createDictionary(@Valid @RequestBody DictionaryCreateDto DictionaryCreateDto){
        DictionaryResponseDto createdDictionary = serviceDictionary.createDictionary(DictionaryCreateDto);
        return new ResponseEntity<>(createdDictionary, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<DictionaryResponseDto>> getAllDictionary(){
        return ResponseEntity.ok(serviceDictionary.getAllDictionary());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DictionaryResponseDto> update(@PathVariable Long id, @Valid @RequestBody DictionaryCreateDto dto) {
        DictionaryResponseDto updatedDictionary = serviceDictionary.update(id, dto);
        return ResponseEntity.ok(updatedDictionary); 
    }


    @GetMapping("{id}")
    public ResponseEntity<DictionaryResponseDto> getDictionaryById(@PathVariable Long id){
        return ResponseEntity.ok(serviceDictionary.getDictionaryById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        serviceDictionary.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
