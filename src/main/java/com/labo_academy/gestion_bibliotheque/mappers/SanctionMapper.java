package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Sanction;
import org.springframework.stereotype.Component;

@Component
public class SanctionMapper {

    // Conversion Entity to Dto
    public SanctionResponseDto fromEntityToDto(Sanction sanction){
        return new SanctionResponseDto(
                sanction.getSanctionedId(),
                sanction.getAmount(),
                sanction.getStatut()
        );
    }
}
