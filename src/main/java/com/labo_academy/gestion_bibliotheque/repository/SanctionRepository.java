package com.labo_academy.gestion_bibliotheque.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Sanction;

public interface SanctionRepository extends JpaRepository<Sanction, Long> {
        
    // Renvoie la date prévue de retour du document emprunté.
    LocalDate findByReturned_Borrow_ReturnDateAndSanctionNumber(String sanctionNumber);

    // Renvoie la date effective de retour du document.
    LocalDate findByReturned_EffectiveReturnDateAndSanctionNumber(String sanctionNumber);

}
