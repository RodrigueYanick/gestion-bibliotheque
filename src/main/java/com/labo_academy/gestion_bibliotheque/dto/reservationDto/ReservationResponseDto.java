package com.labo_academy.gestion_bibliotheque.dto.reservationDto;

import java.time.LocalDate;

public class ReservationResponseDto {

    private Long reservationId;
    private LocalDate reservationDate;
    private boolean active;
    private String subscribersEmail;
    private String documentTitle;

    // Constructeur
    public ReservationResponseDto(Long reservationId,
                                  LocalDate reservationDate,
                                  boolean active,
                                  String subscribersEmail,
                                  String documentTitle) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.active = active;
        this.subscribersEmail = subscribersEmail;
        this.documentTitle = documentTitle;
    }

    // Getters et Setters
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

}
