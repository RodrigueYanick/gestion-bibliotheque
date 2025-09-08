package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.sanctionBillDto.SanctionBillResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.*;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
public class SanctionBillMapper {

    public SanctionBillResponseDto toDto(SanctionBill sanctionBill) {
        if (sanctionBill == null || sanctionBill.getSanction() == null) {
            return null;
        }

        Sanction sanction = sanctionBill.getSanction();
        Returned returned = sanction.getReturned();
        Borrow borrow = returned.getBorrow();
        LibraryClient subscriber = borrow.getSubscriber();
        Document document = borrow.getDocument();

        int dateDiff = (int) ChronoUnit.DAYS.between(
                borrow.getReturnDate(),
                returned.getEffectiveReturnDate()
        );
        dateDiff = Math.max(dateDiff, 0);

        return new SanctionBillResponseDto(
                sanctionBill.getId(),
                sanctionBill.getSanctionBillNumber(),
                subscriber.getLastName(),
                subscriber.getFirstName(),
                subscriber.getAddress(),
                document.getDocumentNumber(),
                document.getTitle(),
                borrow.getBorrowedDate(),
                borrow.getReturnDate(),
                returned.getEffectiveReturnDate(),
                dateDiff,
                sanction.getStatus(),
                sanction.getAmount() // ✅ on réutilise le montant calculé dans Sanction
        );
    }
}
