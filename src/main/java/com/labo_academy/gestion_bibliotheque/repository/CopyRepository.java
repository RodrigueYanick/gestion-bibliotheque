package com.labo_academy.gestion_bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Copy;

public interface CopyRepository extends JpaRepository<Copy, Long> {

    // Chercher toutes les copies associées à un document via son matricule
    List<Copy> findByDocument_DocumentNumber(String documentNumber);

    // Chercher toutes les copies associées à un document via son titre
    List<Copy> findByDocument_Title(String title);

}
