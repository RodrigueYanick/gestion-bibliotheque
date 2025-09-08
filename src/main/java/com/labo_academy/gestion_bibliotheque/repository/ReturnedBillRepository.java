package com.labo_academy.gestion_bibliotheque.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.ReturnedBill;

public interface ReturnedBillRepository extends JpaRepository<ReturnedBill, Long> {
    // Récupère le nom de famille de l’abonné
    Optional<String> findByReturned_Borrow_Subscriber_LastNameAndBillNumber(Long billNumber);
    // Récupère le prénom de l’abonné
    Optional<String> findByReturned_Borrow_Subscriber_FirstNameAndBillNumber(Long billNumber);
    // Récupère l’adresse de l’abonné
    Optional<String> findByReturned_Borrow_Subscriber_AddressAndBillNumber(Long billNumber);
    // Récupère la matricule du document
    Optional<String> findByReturned_Borrow_Document_MatriculeAndBillNumber(Long billNumber);
    // Récupère le titre du document
    Optional<String> findByReturned_Borrow_Document_TitleAndBillNumber(Long billNumber);
    // Récupère la date d’emprunt
    Optional<LocalDate> findByReturned_Borrow_BorrowedDateAndBillNumber(Long billNumber);
    // Récupère la date de retour prévue
    Optional<LocalDate> findByReturned_Borrow_BorrowreturnDateAndBillNumber(Long billNumber);
    // Récupère la date effective de retour
    Optional<LocalDate> findByReturned_EffectiveReturnDateAndBillNumber(Long billNumber);

}
