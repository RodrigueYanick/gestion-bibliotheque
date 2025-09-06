package com.labo_academy.gestion_bibliotheque.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.SanctionBill;

public interface SanctionBillRepository extends JpaRepository<SanctionBill, Long> {

    String findBySanctionReturnedBorrowSubscriberLastName(); 
    String findBySanctionReturnedBorrowSubscriberFirstName(); 
    String findBySanctionReturnedBorrowSubscriberAddress(); 
    String findBySanctionReturnedBorrowDocumentMatricule();
    String findBySanctionReturnedBorrowDocumentTitle();
    LocalDate findBySanctionReturnedBorrowBorrowedDate();
    LocalDate findBySanctionReturnedBorrowreturnDate();
    LocalDate findBySanctionReturnebEffectiveReturnDate();
    String findBySanctionStatut();

}
