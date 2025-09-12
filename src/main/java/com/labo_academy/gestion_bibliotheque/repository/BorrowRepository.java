package com.labo_academy.gestion_bibliotheque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.BorrowedStatus;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import com.labo_academy.gestion_bibliotheque.entity.LibraryClient;
import org.springframework.stereotype.Repository;

@Repository
public interface  BorrowRepository extends JpaRepository<Borrow, Long> {

    Optional<Borrow> findByBorrowedNumber(String borrowedNumber);

    Borrow findBySubscriberAndDocumentAndStatus(LibraryClient subscriber, Document document, BorrowedStatus status);


}
