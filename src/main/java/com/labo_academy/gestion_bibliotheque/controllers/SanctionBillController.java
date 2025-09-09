package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.sanctionBillDto.SanctionBillResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceSanctionBill.SanctionBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sanctionBill")
public class SanctionBillController {

    @Autowired
    private SanctionBillService sanctionBillService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Long sanctionId){
        sanctionBillService.create(sanctionId);
        return ResponseEntity.ok(" creer avec succes");
    }

    @GetMapping("/")
    public List<SanctionBillResponseDto> getAll(){
        return sanctionBillService.getAll();
    }

    @GetMapping("{id}")
    public SanctionBillResponseDto getById(@PathVariable Long id){
        return sanctionBillService.getById(id) ;   }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        sanctionBillService.delete(id);
    }
}
