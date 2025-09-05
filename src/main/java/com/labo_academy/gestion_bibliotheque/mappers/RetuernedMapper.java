package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Returned;
import org.springframework.stereotype.Component;

@Component
public class RetuernedMapper {

    // Conversion Entity To Dto
    public ReturnedResponseDto fromEntityToDto(Returned returned){
        return new ReturnedResponseDto(
               returned.getId(),
               returned.getEffectiveReturnDate()
        );
    }
}
