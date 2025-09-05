package com.labo_academy.gestion_bibliotheque.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.BorrowedBill;

public interface BorrowBillRepository extends JpaRepository<BorrowedBill, Long> {

    String findByBorrowSubscriberLastName(); 
    String findByBorrowSubscriberFirstName(); 
    String findByBorrowSubscriberAddress(); 
    String findByBorrowDocumentMatricule();
    String findByBorrowDocumentTitle();
    LocalDate findByBorrowedDate();
    LocalDate findByreturnDate();

}
