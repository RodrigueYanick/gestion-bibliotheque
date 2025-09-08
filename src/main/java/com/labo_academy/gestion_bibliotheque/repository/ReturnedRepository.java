package com.labo_academy.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Returned;

public interface ReturnedRepository extends JpaRepository<Returned, Long> {

    Returned findByBorrow_Subscriber_Email(String email);


}
