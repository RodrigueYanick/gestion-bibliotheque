package com.labo_academy.gestion_bibliotheque.returnedDto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ReturnedResponseDto {

    private Long Id;
    private LocalDate returndeDate;

}
