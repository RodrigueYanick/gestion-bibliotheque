package com.labo_academy.gestion_bibliotheque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByLastName(String lastName);
    Users findByEmail(String email);

}
