package com.labo_academy.gestion_bibliotheque.dto.sanctionDto;

import com.labo_academy.gestion_bibliotheque.entity.SanctionStatus;

public class SanctionResponseDto {

    private Long sanctionedId;
    private double amount;
    private String sanctionNumber;
    private SanctionStatus status;

    // Constructeur complet
    public SanctionResponseDto(Long sanctionedId, double amount, String sanctionNumber, SanctionStatus status) {
        this.sanctionedId = sanctionedId;
        this.amount = amount;
        this.sanctionNumber = sanctionNumber;
        this.status = status;
    }

    // Getters et Setters
    public Long getSanctionedId() {
        return sanctionedId;
    }

    public void setSanctionedId(Long sanctionedId) {
        this.sanctionedId = sanctionedId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSanctionNumber() {
        return sanctionNumber;
    }

    public void setSanctionNumber(String sanctionNumber) {
        this.sanctionNumber = sanctionNumber;
    }

    public SanctionStatus getStatus() {
        return status;
    }

    public void setStatus(SanctionStatus status) {
        this.status = status;
    }
}
