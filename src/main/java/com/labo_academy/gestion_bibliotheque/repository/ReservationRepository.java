package com.labo_academy.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
