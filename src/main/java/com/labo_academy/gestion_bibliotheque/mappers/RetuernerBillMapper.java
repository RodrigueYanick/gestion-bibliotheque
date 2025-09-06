package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.*;
import com.labo_academy.gestion_bibliotheque.repository.BorrowRepository;
import com.labo_academy.gestion_bibliotheque.repository.ReturnedBillRepository;

public class RetuernerBillMapper {
    BorrowRepository borrowRepository;
    ReturnedBillRepository returnedBillRepository;



    // Entity to Dto
    public ReturnedBillResponseDto fromEntityToDto(ReturnedBill returnedBill){
    Subscribers subscribers;
    Document document;
    Borrow borrow;
        return  new ReturnedBillResponseDto(
                returnedBill.getBillNumber(),
                //returnedBill.getReturned().getEffectiveReturnDate(),
                returnedBillRepository.findByReturnedEffectiveReturnDateNumber(),
                returnedBillRepository.findByReturnedBorrowSubscriberLastName(),
                returnedBillRepository.findByReturnedBorrowSubscriberFirstName(),
                returnedBillRepository.findByReturnedBorrowSubscriberAddress(),
                returnedBillRepository.findByReturnedBorrowDocumentMatricule(),
                returnedBillRepository.findByReturnedBorrowDocumentTitle(),
                returnedBillRepository.findByReturnedBorrowBorrowedDate(),
                returnedBillRepository.findByReturnebEffectiveReturnDate(),
                returnedBillRepository.findByBorrowDateDiffusion(),
                returnedBillRepository.findBySanction()

        );
    }

    /*
    // Calcul la difference de  Date
    public Long calculeDifferenceJoure(LocalDate effectiveReturnedDate,LocalDate borrowedReturnDate){
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate Start = LocalDate.parse(borrowedReturnDate,formater);
        LocalDate end = LocalDate.parse(effectiveReturnedDate,formater);
        return ChronoUnit.DAYS.between(Start,end);
    }

     */

    // Dto to Entity
    public ReturnedBill fromDtoToEntity(ReturnedBillCreateDto returnedBillCreateDto){
        ReturnedBill returnedBill = new ReturnedBill();
        Borrow borrow = borrowRepository.findByBorrowedNumber(returnedBillCreateDto.getEffectiveReturnDateNumber());
        return returnedBill;
    }

}
