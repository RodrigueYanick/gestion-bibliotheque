package com.labo_academy.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Magazine;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {

}
