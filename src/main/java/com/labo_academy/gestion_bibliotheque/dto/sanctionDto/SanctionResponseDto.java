package com.labo_academy.gestion_bibliotheque.dto.sanctionDto;

import com.labo_academy.gestion_bibliotheque.entity.SanctionStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class SanctionResponseDto {

    private Long sanctionedId;
    private double amount;
    private SanctionStatus statut;

}
