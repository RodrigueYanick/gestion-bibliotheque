package com.labo_academy.gestion_bibliotheque.dto.sanctionDto;

import com.labo_academy.gestion_bibliotheque.entity.SanctionStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class SanctionResponseDto {

    private Long sanctionedId;
    private double amount;
    private String sanctionNumber;
    private SanctionStatus status;
    private String subscriberName;
    private String documentTitle;

}
