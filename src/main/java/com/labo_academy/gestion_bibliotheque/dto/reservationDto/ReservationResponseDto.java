package com.labo_academy.gestion_bibliotheque.dto.reservationDto;

import java.time.LocalDate;

public class ReservationResponseDto {

    private Long reservationId;
    private LocalDate reservationDate;
    private boolean statut;
    private String subscribersEmail;
    private String documentTitle;

    public ReservationResponseDto(Long reservationId, LocalDate reservationDate, boolean statut,String subscribersEmail,String documentTitle) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.statut = statut;
        this.subscribersEmail = subscribersEmail;
        this.documentTitle = documentTitle;


    }
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

}
