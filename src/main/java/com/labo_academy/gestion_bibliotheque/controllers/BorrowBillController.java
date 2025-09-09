package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.borrowBillDto.BorrowedBillResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceBorrowBill.BorrowBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/borrowBill")
public class BorrowBillController {

    @Autowired
    private BorrowBillService borrowBillService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Long borrowId){
        borrowBillService.create(borrowId);
        return ResponseEntity.ok(" creer avec succes");
    }

    @GetMapping("/")
    public List<BorrowedBillResponseDto> getAll(){
        return borrowBillService.findAll();
    }

    @GetMapping("{id}")
    public BorrowedBillResponseDto getById(@PathVariable Long id){
        return borrowBillService.findById(id) ;   }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        borrowBillService.delete(id);
    }

}
