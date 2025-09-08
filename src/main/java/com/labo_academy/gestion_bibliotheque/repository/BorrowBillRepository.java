package com.labo_academy.gestion_bibliotheque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.BorrowedBill;

public interface BorrowBillRepository extends JpaRepository<BorrowedBill, Long> {

    // Récupère le nom de famille de l’abonné (Subscribers.lastName)
    Optional<String> findBorrowSubscribersLastNameByBillNumber(Long billNumber);
    // Récupère le prénom de l’abonné (Subscribers.firstName)
    Optional<String> findBorrowSubscribersFirstNameByBillNumber(Long billNumber);
    // Récupère l’adresse de l’abonné (Subscribers.address)
    Optional<String> findBorrowSubscribersAdresseByBillNumber(Long billNumber);
    // Récupère la matricule du document (Document.matricule)
    Optional<String> findBorrowDocumentMatriculeByBillNumber(Long billNumber);
    // Récupère le titre du document (Document.title)
    Optional<String> findBorrowDocumentTitleByBillNumber(Long billNumber);
    // Récupère le titre du document (Document.title)
    Optional<String> findBorrowBorrowedDateByBillNumber(Long billNumber);
    // Récupère la date de retour prévue (Borrow.returnDate)
    Optional<String> findReturnDateByBillNumber(Long billNumber);
    // Récupère le numéro d’emprunt (Borrow.borrowedNumber)
    Optional<String> findBorrowNumberByBillNumber(Long billNumber);

}
