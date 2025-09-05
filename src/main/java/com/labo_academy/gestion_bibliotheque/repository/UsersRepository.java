package com.labo_academy.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
