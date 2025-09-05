package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.borrowBillDto.BorrowedBillCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.borrowBillDto.BorrowedBillResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.BorrowedBill;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import com.labo_academy.gestion_bibliotheque.entity.Subscribers;
import com.labo_academy.gestion_bibliotheque.repository.BorrowRepository;
import com.labo_academy.gestion_bibliotheque.repository.DocumentRepository;
import com.labo_academy.gestion_bibliotheque.repository.SubscribersRepository;

public class BorrowBillMapper {
    SubscribersRepository subscribersRepository;
    BorrowRepository borrowRepository;
    DocumentRepository documentRepository;

    Borrow borrow;
    Document document;
    Subscribers subscribers;

    // Conversion Entity to Dto
    public BorrowedBillResponseDto EntityToDto(BorrowedBill borrowedBill){
        return new BorrowedBillResponseDto(
                borrowedBill.getBillNumber(),
                borrowedBill.getBorrow().getBorrowedNumber(),
                borrowedBill.getBorrow().getSuscriber().getLastName(),
                borrowedBill.getBorrow().getSuscriber().getFirstName(),
                borrowedBill.getBorrow().getSuscriber().getAddress(),
                borrowedBill.getBorrow().getDocument().getMatricule(),
                borrowedBill.getBorrow().getDocument().getTitle(),
                borrowedBill.getBorrow().getBorrowedDate(),
                borrowedBill.getBorrow().getReturnDate()
        );
    }

    // Conversion Dto to Entity
    public BorrowedBill fromDtoToEntity(BorrowedBillCreateDto borrowedBillCreateDto){
        BorrowedBill borrowedBill = new BorrowedBill();
        Borrow borrow1 = borrowRepository.findByBorrowedNumber(borrowedBillCreateDto.getBorrowedNumber());
        return borrowedBill;
    }

}
