package com.labo_academy.gestion_bibliotheque.dto.borrowBillDto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BorrowedBillResponseDto {

    private Long billNumber;
    private String borrowedNumber;
    private String subscribersLastName;
    private String subscribersFirstname;
    private String subscribersAddresse;
    private String documentMatricule;
    private String documentTitle;
    private LocalDate borrowedDate;
    private LocalDate borrowedReturnDate;

}
