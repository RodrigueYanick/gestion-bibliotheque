package com.labo_academy.gestion_bibliotheque.dto.sanctionBillDto;

import java.time.LocalDate;

import com.labo_academy.gestion_bibliotheque.entity.SanctionStatus;

public class SanctionBillResponseDto {

    private Long id;
    private LocalDate effectiveReturnDateNumber;
    private String subscribersLastName;
    private String subscribersFirstname;
    private String subscribersAddresse;
    private String documentMatricule;
    private String documentTitle;
    private LocalDate borrowedDate;
    private LocalDate borrowedReturnDate;
    private LocalDate effectiveReturnedDate;
    private int dateDiff;
    private SanctionStatus status;
    private double amount;

}
