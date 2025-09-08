package com.labo_academy.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import com.labo_academy.gestion_bibliotheque.entity.LibraryClient;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    Borrow findByBorrowedNumber(String matricule);

    
    Borrow findBySubscriberAndDocumentAndStatusActive(LibraryClient subscribers, Document document);

}
