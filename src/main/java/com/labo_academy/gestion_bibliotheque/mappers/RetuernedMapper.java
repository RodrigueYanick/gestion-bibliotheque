package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Returned;
import com.labo_academy.gestion_bibliotheque.entity.Subscribers;
import com.labo_academy.gestion_bibliotheque.repository.ReturnedRepository;
import org.springframework.stereotype.Component;

@Component
public class RetuernedMapper {

    ReturnedRepository returnedRepository;

    // Conversion Entity To Dto
    public ReturnedResponseDto fromEntityToDto(Returned returned){
        return new ReturnedResponseDto(
               returned.getId(),
               returned.getReturndeDate()
        );
    }

    // Conversion Dto to Entity
    public Returned fromDtoToEntity(ReturnedCreateDto returnedCreateDto){
        Returned returned = returnedRepository.findByBorrowSubscriberEmail(returnedCreateDto.getReturendEmail());
        return returned;
    }
}
