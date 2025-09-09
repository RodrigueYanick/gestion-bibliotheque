package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceBorrow.ServiceBorrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/borrow")
public class BorrowController {

    @Autowired
    private ServiceBorrow serviceBorrow;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody BorrowCreateDto borrowCreateDto){
        serviceBorrow.createBorrow(borrowCreateDto);
        return ResponseEntity.ok(" creer avec succes");
    }

    @GetMapping("/")
    public List<BorrowResponseDto> getAll(){
        return serviceBorrow.getAllBorrow();
    }

    @GetMapping("{id}")
    public BorrowResponseDto getById(@PathVariable Long id){
        return serviceBorrow.getBorrowById(id) ;   }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        serviceBorrow.deleteById(id);
    }
}
