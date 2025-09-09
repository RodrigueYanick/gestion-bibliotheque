package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Book;
import com.labo_academy.gestion_bibliotheque.services.serviceBook.ServiceBook;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private ServiceBook serviceBook;

    @PostMapping("/create")
    public ResponseEntity<BookResponseDto> createBook(@Valid @RequestBody BookCreateDto BookCreateDto){
        BookResponseDto createdBook = serviceBook.createBook(BookCreateDto);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookResponseDto>> getAllBook(){
        return ResponseEntity.ok(serviceBook.getAllBookk());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookResponseDto> update(@PathVariable Long id, @Valid @RequestBody BookCreateDto dto) {
        BookResponseDto updatedBook = serviceBook.update(id, dto);
        return ResponseEntity.ok(updatedBook); // retourne 200 OK avec l'objet mis à jour
    }


    @GetMapping("{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(serviceBook.getBookById(id));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        serviceBook.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search/{lastName}")
    public Book findBookByAuthor(String title){
        return serviceBook.findBookByTitle(title);
    }

}
