package com.labo_academy.gestion_bibliotheque.dto.returnBillDto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReturnedBillResponseDto {

    private Long billNumber;
    private LocalDate effectiveReturnDateNumber;
    private String subscribersLastName;
    private String subscribersFirstname;
    private String subscribersAdresse;
    private String documentMatricule;
    private String documentTitle;
    private LocalDate borrowedDate;
    private LocalDate borrowedReturnDate;
    private LocalDate effectiveReturnedDate;
    private int dateDiff;
    private double sanction;

}
