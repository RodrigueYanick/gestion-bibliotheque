
package com.labo_academy.gestion_bibliotheque.dto.reservationDto;

import java.time.LocalDate;

public class ReservationCreateDto {

    private LocalDate reservationDate;
    private boolean statut;
    private String subscribersEmail;
    private String documentTitle;

    public ReservationCreateDto(LocalDate reservationDate, boolean statut,String subscribersEmail, String documentTitle) {
        this.reservationDate = reservationDate;
        this.statut = statut;
        this.subscribersEmail = subscribersEmail;
        this.documentTitle = documentTitle;
    }

    public String getSubscribersEmail() {
        return subscribersEmail;
    }

    public void setSubscribersEmail(String subscribersEmail) {
        this.subscribersEmail = subscribersEmail;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
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
