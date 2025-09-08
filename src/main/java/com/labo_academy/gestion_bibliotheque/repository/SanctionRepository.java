package com.labo_academy.gestion_bibliotheque.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Sanction;

public interface SanctionRepository extends JpaRepository<Sanction, Long> {
        

}
