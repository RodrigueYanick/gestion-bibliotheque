package com.labo_academy.gestion_bibliotheque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.BorrowedBill;
import org.springframework.stereotype.Repository;

@Repository

public interface BorrowBillRepository extends JpaRepository<BorrowedBill, Long> {

    /*
    // Récupère le nom de famille de l’abonné (Subscribers.lastName)
    String findBorrowSubscribersLastNameByBillNumber(Long billNumber);
    // Récupère le prénom de l’abonné (Subscribers.firstName)
    String findBorrowSubscribersFirstNameByBillNumber(Long billNumber);
    // Récupère l’adresse de l’abonné (Subscribers.address)
    String findBorrowSubscribersAdresseByBillNumber(Long billNumber);
    // Récupère la matricule du document (Document.matricule)
    String findBorrowDocumentMatriculeByBillNumber(Long billNumber);
    // Récupère le titre du document (Document.title)
    String findBorrowDocumentTitleByBillNumber(Long billNumber);
    // Récupère le titre du document (Document.title)
    String findBorrowBorrowedDateByBillNumber(Long billNumber);
    // Récupère la date de retour prévue (Borrow.returnDate)
    String findReturnDateByBillNumber(Long billNumber);
    // Récupère le numéro d’emprunt (Borrow.borrowedNumber)
    String findBorrowNumberByBillNumber(Long billNumber);


     */
}
