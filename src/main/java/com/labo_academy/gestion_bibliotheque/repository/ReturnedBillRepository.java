package com.labo_academy.gestion_bibliotheque.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.ReturnedBill;

public interface ReturnedBillRepository extends JpaRepository<ReturnedBill, Long> {

    String findByReturnedBorrowSubscriberLastName(); 
    String findByReturnedBorrowSubscriberFirstName(); 
    String findByReturnedBorrowSubscriberAddress(); 
    String findByReturnedBorrowDocumentMatricule();
    String findByReturnedBorrowDocumentTitle();
    LocalDate findByReturnedBorrowBorrowedDate();
    LocalDate findByReturnedBorrowreturnDate();
    LocalDate findByReturnebEffectiveReturnDate();

}
