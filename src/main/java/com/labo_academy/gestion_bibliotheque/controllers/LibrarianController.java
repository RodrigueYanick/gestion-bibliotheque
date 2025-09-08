package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookResponseDto;
import com.labo_academy.gestion_bibliotheque.repository.LibrarianRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceLibrarian.ServiceLibrarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/librarian")
public class LibrarianController {

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private ServiceLibrarian serviceLibrarian;


}
