package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Book;
import com.labo_academy.gestion_bibliotheque.repository.BookRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceBook.ServiceBook;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ServiceBook serviceBook;

    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody BookCreateDto bookCreateDto){
        serviceBook.createBook(bookCreateDto);
        return ResponseEntity.ok("Livre creer avec succes");
    }

    @GetMapping("/")
    public List<BookResponseDto> getAllBook(){
        return serviceBook.getAllBookk();
    }

    @PutMapping("/update/{id}/{book}")
    public BookResponseDto update(Long id, BookCreateDto dto){
        return serviceBook.update(id,dto);
    }

    @GetMapping("{id}")
    public BookResponseDto getBookById(@PathVariable Long id){
        return serviceBook.getBookById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        serviceBook.deleteById(id);
    }
    @GetMapping("/search/{nameAuthor}")
    public List<Book> findBookByAuthor(String nameAuthor){
        return serviceBook.findBookByAuthor(nameAuthor);
    }

    @GetMapping("/search/categoryName")
    public List<Book> findBookByCategory(String categoryName){
        return serviceBook.findBookByCategory(categoryName);
    }

}
