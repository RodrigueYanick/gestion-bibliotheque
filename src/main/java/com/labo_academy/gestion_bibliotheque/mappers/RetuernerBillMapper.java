package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.ReturnedBill;
import com.labo_academy.gestion_bibliotheque.repository.BorrowRepository;

public class RetuernerBillMapper {
    BorrowRepository borrowRepository;


    // Entity to Dto
    public ReturnedBillResponseDto fromEntityToDto(ReturnedBill returnedBill){
        return  new ReturnedBillResponseDto(
                returnedBill.getBillNumber()
        );
    }

    // Dto to Entity
    public ReturnedBill fromDtoToEntity(ReturnedBillCreateDto returnedBillCreateDto){
        ReturnedBill returnedBill = new ReturnedBill();
        Borrow borrow = borrowRepository.findByBorrowedNumber(returnedBillCreateDto.getEffectiveReturnDateNumber());
        return returnedBill;
    }
}
