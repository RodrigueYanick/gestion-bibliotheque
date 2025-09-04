package com.labo_academy.gestion_bibliotheque.dto.reservationDto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ReservationResponseDto {

    private Long reservationId;
    private LocalDate reservationDate;
    private boolean statut;

}
