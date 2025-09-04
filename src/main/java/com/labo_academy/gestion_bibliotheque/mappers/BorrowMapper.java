package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import org.springframework.stereotype.Component;

@Component
public class BorrowMapper {

    // Conversion Entity To Dto
    public BorrowResponseDto fromEntityToDto(Borrow borrow){
        return new BorrowResponseDto(
                borrow.getBorrowedId(),
                borrow.getStatus(),
                borrow.getBorrowedDate(),
                borrow.getReturnDate()
        );
    }

    // Conversion Dto To Entity
    public Borrow fromDtoToEntity(BorrowCreateDto borrowCreateDto){
        Borrow borrow = new Borrow();
        borrow.setStatus(borrowCreateDto.getStatus());
        return borrow;
    }
}
