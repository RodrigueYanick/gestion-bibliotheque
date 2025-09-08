package com.labo_academy.gestion_bibliotheque.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.SanctionBill;

public interface SanctionBillRepository extends JpaRepository<SanctionBill, Long> {

// Récupère le nom de famille de l'abonné ayant effectué l'emprunt retourné sanctionné, à partir du numéro de facture de sanction.
String findBySanction_Returned_Borrow_Subscriber_LastNameAndSanctionBillNumber(String sanctionBillNumber); 

// Récupère le prénom de l'abonné ayant effectué l'emprunt retourné sanctionné, à partir du numéro de facture de sanction.
String findBySanction_Returned_Borrow_Subscriber_FirstNameAndSanctionBillNumber(String sanctionBillNumber); 

// Récupère l'adresse de l'abonné ayant effectué l'emprunt retourné sanctionné, à partir du numéro de facture de sanction.
String findBySanction_Returned_Borrow_Subscriber_AddressAndSanctionBillNumber(String sanctionBillNumber); 

// Récupère le matricule du document emprunté dans le cadre de l'emprunt retourné sanctionné.
String findBySanction_Returned_Borrow_Document_MatriculeAndSanctionBillNumber(String sanctionBillNumber);

// Récupère le titre du document emprunté dans le cadre de l'emprunt retourné sanctionné.
String findBySanction_Returned_Borrow_Document_TitleAndSanctionBillNumber(String sanctionBillNumber);

// Récupère la date d'emprunt du document concerné par la sanction, à partir du numéro de facture.
LocalDate findBySanction_Returned_Borrow_BorrowedDateAndSanctionBillNumber(String sanctionBillNumber);

// Récupère la date prévue de retour du document, dans le cadre de l'emprunt sanctionné.
LocalDate findBySanction_Returned_Borrow_ReturnDateAndSanctionBillNumber(String sanctionBillNumber);

// Récupère la date effective de retour du document emprunté.
LocalDate findBySanction_Returned_EffectiveReturnDateAndSanctionBillNumber(String sanctionBillNumber);


}
