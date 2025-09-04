package com.labo_academy.gestion_bibliotheque.dto.borrowDto;

import java.time.LocalDate;

import com.labo_academy.gestion_bibliotheque.entity.BorrowedStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BorrowResponseDto {

    private Long borrowedId;
    private BorrowedStatus status;
    private LocalDate borrowedDate;
    private LocalDate returnDate;

}
