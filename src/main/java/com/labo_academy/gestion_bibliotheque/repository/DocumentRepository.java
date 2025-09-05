package com.labo_academy.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    Document findByTitle(String title);

}
