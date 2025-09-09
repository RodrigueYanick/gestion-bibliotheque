package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceReturnedBill.ReturnedBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/returnedBill")
public class ReturnBillController {

    @Autowired
    private ReturnedBillService returnedBillService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ReturnedBillCreateDto returnedBillCreateDto){
        returnedBillService.create(returnedBillCreateDto);
        return ResponseEntity.ok(" creer avec succes");
    }

    @GetMapping("/")
    public List<ReturnedBillResponseDto> getAll(){
        return returnedBillService.findAll();
    }

    @GetMapping("{id}")
    public ReturnedBillResponseDto getById(@PathVariable Long id){
        return returnedBillService.findById(id);   }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        returnedBillService.delete(id);
    }
}
