package com.labo_academy.gestion_bibliotheque.dto.sanctionDto;


import com.labo_academy.gestion_bibliotheque.entity.SanctionStatus;

public class SanctionResponseDto {

    private Long sanctionedId;
    private double amount;
    private SanctionStatus statut;

    public SanctionResponseDto(Long sanctionedId, double amount, SanctionStatus statut) {
        this.sanctionedId = sanctionedId;
        this.amount = amount;
        this.statut = statut;
    }

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

    public SanctionStatus getStatut() {
        return statut;
    }

    public void setStatut(SanctionStatus statut) {
        this.statut = statut;
    }
}
