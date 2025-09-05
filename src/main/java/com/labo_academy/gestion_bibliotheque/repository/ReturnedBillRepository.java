package com.labo_academy.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.ReturnedBill;

public interface ReturnedBillRepository extends JpaRepository<ReturnedBill, Long> {

}
