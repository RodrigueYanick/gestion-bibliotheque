package com.labo_academy.gestion_bibliotheque.dto.reservationDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ReservationResponseDto {

    private Long reservationId;
    private LocalDate reservationDate;
    private boolean statut;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public ReservationResponseDto(Long reservationId, LocalDate reservationDate, boolean statut) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.statut = statut;


    }
}