package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceReturnedBill.ReturnedBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/returnedBill")
public class ReturnBillController {

    @Autowired
    private ReturnedBillService returnedBillService;

    @PostMapping("/create")
    public ResponseEntity<ReturnedBillResponseDto> create(@RequestBody ReturnedBillCreateDto returnedBillCreateDto){
        ReturnedBillResponseDto returnBill = returnedBillService.create(returnedBillCreateDto);
        return new ResponseEntity<>(returnBill, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ReturnedBillResponseDto>> getAll(){
        return ResponseEntity.ok(returnedBillService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ReturnedBillResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(returnedBillService.findById(id));   
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        returnedBillService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
