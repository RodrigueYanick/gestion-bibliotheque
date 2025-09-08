package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.Returned;
import com.labo_academy.gestion_bibliotheque.entity.ReturnedBill;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class ReturnedBillMapper {

    private static final double SANCTION_PER_DAY = 2500;

    // ---------- Entity -> DTO --------
    public ReturnedBillResponseDto toDto(ReturnedBill returnedBill) {
        if (returnedBill == null) {
            return null;
        }

        Returned returned = returnedBill.getReturned();
        Borrow borrow = returned.getBorrow();

        // Données de base
        String subscribersLastName = borrow.getSubscriber().getLastName();
        String subscribersFirstname = borrow.getSubscriber().getFirstName();
        String subscribersAdresse = borrow.getSubscriber().getAddress();
        String documentMatricule = borrow.getDocument().getDocumentNumber();
        String documentTitle = borrow.getDocument().getTitle();

        LocalDate borrowedDate = borrow.getBorrowedDate();
        LocalDate borrowedReturnDate = borrow.getReturnDate();
        LocalDate effectiveReturnedDate = returned.getEffectiveReturnDate();

        // Calcul du retard
        int dateDiff = (int) ChronoUnit.DAYS.between(borrowedReturnDate, effectiveReturnedDate);
        dateDiff = Math.max(dateDiff, 0); // si pas de retard → 0

        // Montant de sanction
        double sanctionAmount = dateDiff * SANCTION_PER_DAY;

        return new ReturnedBillResponseDto(
                returnedBill.getId(),
                returnedBill.getBillNumber(),
                subscribersLastName,
                subscribersFirstname,
                subscribersAdresse,
                documentMatricule,
                documentTitle,
                borrowedDate,
                borrowedReturnDate,
                effectiveReturnedDate,
                dateDiff,
                sanctionAmount
        );
    }

    // ------- CreateDto -> Entity -------
    public ReturnedBill toEntity(ReturnedBillCreateDto dto, Returned returned) {
        if (dto == null || returned == null) {
            return null;
        }

        ReturnedBill returnedBill = new ReturnedBill();
        returnedBill.setReturned(returned);
        return returnedBill;
    }
}
