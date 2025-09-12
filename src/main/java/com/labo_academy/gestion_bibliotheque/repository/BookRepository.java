package com.labo_academy.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByTitle(String title);


}
