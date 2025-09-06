package com.labo_academy.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Copy;

public interface CopyRepository extends JpaRepository<Copy, Long> {

    String findByDocumentMatricule();
    String findByDocumentTitle();

}
