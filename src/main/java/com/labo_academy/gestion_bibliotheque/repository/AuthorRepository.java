package com.labo_academy.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByLastName();

}
