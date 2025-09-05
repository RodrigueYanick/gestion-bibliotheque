
package com.labo_academy.gestion_bibliotheque.dto.reservationDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter

public class ReservationCreateDto {

    private LocalDate reservationDate;
    private boolean statut;
    private String subscribersEmail;
    private String documentTitle;

    public ReservationCreateDto(LocalDate reservationDate, boolean statut) {
        this.reservationDate = reservationDate;
        this.statut = statut;
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
}
