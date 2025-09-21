package com.labo_academy.gestion_bibliotheque.dto.returnBillDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReturnedBillResponseDto {

    private Long id;
    private String billNumber;
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

    public ReturnedBillResponseDto(Long id,
                                   String billNumber,
                                   String subscribersLastName,
                                   String subscribersFirstname,
                                   String subscribersAdresse,
                                   String documentMatricule,
                                   String documentTitle,
                                   LocalDate borrowedDate,
                                   LocalDate borrowedReturnDate,
                                   LocalDate effectiveReturnedDate,
                                   int dateDiff,
                                   double sanction) {
        this.id = id;
        this.billNumber = billNumber;
        this.subscribersLastName = subscribersLastName;
        this.subscribersFirstname = subscribersFirstname;
        this.subscribersAdresse = subscribersAdresse;
        this.documentMatricule = documentMatricule;
        this.documentTitle = documentTitle;
        this.borrowedDate = borrowedDate;
        this.borrowedReturnDate = borrowedReturnDate;
        this.effectiveReturnedDate = effectiveReturnedDate;
        this.dateDiff = dateDiff;
        this.sanction = sanction;
    }
}
