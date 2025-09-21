package com.labo_academy.gestion_bibliotheque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.BorrowedBill;

import org.springframework.stereotype.Repository;

@Repository

public interface BorrowBillRepository extends JpaRepository<BorrowedBill, Long> {

    

}
