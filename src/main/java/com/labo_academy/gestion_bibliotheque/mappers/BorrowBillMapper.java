package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.borrowBillDto.BorrowedBillCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.borrowBillDto.BorrowedBillResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.BorrowedBill;
import org.springframework.stereotype.Component;

@Component
public class BorrowBillMapper {

    // to dto
    public BorrowedBillResponseDto toDto(BorrowedBill borrowedBill){
        return new BorrowedBillResponseDto(borrowedBill.getBorrowedId(), borrowedBill.getBorrow().getSubscriber().getLastName(), borrowedBill.getBorrow().getSubscriber().getFirstName(), borrowedBill.getBorrow().getSubscriber().getAddress(), borrowedBill.getBorrow().getDocument().getDocumentNumber(), borrowedBill.getBorrow().getDocument().getTitle(), borrowedBill.getBorrow().getBorrowedDate(), borrowedBill.getBorrow().getReturnDate());
    }

    public BorrowedBill toEntity(BorrowedBillCreateDto dto, Borrow borrow){
        if(dto == null || borrow == null){
            return null;
        }
        BorrowedBill bill = new BorrowedBill();
        bill.setBorrow(borrow);
        return bill;
    }
}
