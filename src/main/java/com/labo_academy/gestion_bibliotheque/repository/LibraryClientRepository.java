package com.labo_academy.gestion_bibliotheque.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.LibraryClient;

public interface LibraryClientRepository extends JpaRepository<LibraryClient, Long> {

    LibraryClient findByEmail(String email);

}
