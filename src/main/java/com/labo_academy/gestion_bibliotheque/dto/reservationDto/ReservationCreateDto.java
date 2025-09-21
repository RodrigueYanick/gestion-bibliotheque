package com.labo_academy.gestion_bibliotheque.dto.reservationDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ReservationCreateDto {

    @NotNull(message = "La date de réservation est obligatoire")
    private LocalDate reservationDate;

    @NotBlank(message = "L'email de l'abonné est obligatoire")
    @Email(message = "Format d'email invalide")
    private String subscribersEmail;

    @NotBlank(message = "Le titre du document est obligatoire")
    private String documentTitle;

    // Constructeur
    public ReservationCreateDto(LocalDate reservationDate, String subscribersEmail, String documentTitle) {
        this.reservationDate = reservationDate;
        this.subscribersEmail = subscribersEmail;
        this.documentTitle = documentTitle;
    }

    // Getters et Setters
    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
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
