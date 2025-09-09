package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryResponseDto;
import com.labo_academy.gestion_bibliotheque.repository.DictionaryRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceDictionary.ServiceDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    private ServiceDictionary serviceDictionary;

    @PostMapping("/create")
    public ResponseEntity<String> createDictionary(@RequestBody DictionaryCreateDto dictionaryCreateDto){
        serviceDictionary.createDictionary(dictionaryCreateDto);
        return ResponseEntity.ok("Dictionary creer avec succes");
    }

    @GetMapping("/")
    public List<DictionaryResponseDto> getAllDictionary(){
        return serviceDictionary.getAllDictionary();
    }

    @PutMapping("/update/{id}/{dictionary}")
    public DictionaryResponseDto update(Long id, DictionaryCreateDto dto){
        return serviceDictionary.update(id,dto);
    }

    @GetMapping("{id}")
    public DictionaryResponseDto getDictionaryById(@PathVariable Long id){
        return serviceDictionary.getDictionaryById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        serviceDictionary.deleteById(id);
    }
}
