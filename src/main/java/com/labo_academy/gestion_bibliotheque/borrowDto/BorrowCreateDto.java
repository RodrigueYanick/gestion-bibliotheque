package com.labo_academy.gestion_bibliotheque.borrowDto;

import java.time.LocalDate;

import com.labo_academy.gestion_bibliotheque.entity.BorrowedStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BorrowCreateDto {

    private BorrowedStatus status;

}
