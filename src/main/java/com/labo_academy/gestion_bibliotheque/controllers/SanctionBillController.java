package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.sanctionBillDto.SanctionBillResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceSanctionBill.SanctionBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sanctionBill")
public class SanctionBillController {

    @Autowired
    private SanctionBillService sanctionBillService;

    @PostMapping("/create")
    public ResponseEntity<SanctionBillResponseDto> create(@RequestBody Long sanctionId){
        return new ResponseEntity<>(sanctionBillService.create(sanctionId), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<SanctionBillResponseDto>> getAll(){
        return ResponseEntity.ok(sanctionBillService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<SanctionBillResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(sanctionBillService.getById(id)); 
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        sanctionBillService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
