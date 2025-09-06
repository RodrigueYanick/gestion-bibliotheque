package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.borrowBillDto.BorrowedBillCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.borrowBillDto.BorrowedBillResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.BorrowedBill;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import com.labo_academy.gestion_bibliotheque.entity.Subscribers;
import com.labo_academy.gestion_bibliotheque.repository.BorrowBillRepository;
import com.labo_academy.gestion_bibliotheque.repository.BorrowRepository;
import com.labo_academy.gestion_bibliotheque.repository.DocumentRepository;
import com.labo_academy.gestion_bibliotheque.repository.SubscribersRepository;

public class BorrowBillMapper {
    SubscribersRepository subscribersRepository;
    BorrowRepository borrowRepository;
    DocumentRepository documentRepository;
    BorrowBillRepository borrowBillRepository;

    Borrow borrow;
    Document document;
    Subscribers subscribers;

    // Conversion Entity to Dto
    public BorrowedBillResponseDto EntityToDto(BorrowedBill borrowedBill){
        return new BorrowedBillResponseDto(
                borrowedBill.getBillNumber(),
                borrowBillRepository.findByBorrowNumber(),
                borrowBillRepository.findByBorrowSubscriberLastName(),
                borrowBillRepository.findByBorrowSubscriberFirstName(),
                borrowBillRepository.findByBorrowSubscriberAddress(),
                borrowBillRepository.findByBorrowDocumentMatricule(),
                borrowBillRepository.findByBorrowDocumentTitle(),
                borrowBillRepository.findByBorrowedDate(),
                borrowBillRepository.findByreturnDate()
        );
    }

    // Conversion Dto to Entity
    public BorrowedBill fromDtoToEntity(BorrowedBillCreateDto borrowedBillCreateDto){
        BorrowedBill borrowedBill = new BorrowedBill();
        Borrow borrow1 = borrowRepository.findByBorrowedNumber(borrowedBillCreateDto.getBorrowedNumber());
        return borrowedBill;
    }

}
