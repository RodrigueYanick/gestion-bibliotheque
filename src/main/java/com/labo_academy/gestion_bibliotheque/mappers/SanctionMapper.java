package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class SanctionMapper {

    private static final double SANCTION_PER_DAY = 2500;

    // ===== Entity -> DTO =====
    public SanctionResponseDto toDto(Sanction sanction) {
        if (sanction == null) {
            return null;
        }

        // enrichir la réponse avec infos abonne + document
        Returned returned = sanction.getReturned();
        Borrow borrow = returned.getBorrow();

        String subscriberName = borrow.getSubscriber().getLastName() + " " + borrow.getSubscriber().getFirstName();
        String documentTitle = borrow.getDocument().getTitle();

        return new SanctionResponseDto(
                sanction.getId(),
                sanction.getAmount(),
                sanction.getSanctionNumber(),
                sanction.getStatus(),
                subscriberName,
                documentTitle
        );
    }

    
    public Sanction fromReturned(Returned returned) {
        if (returned == null) {
            return null;
        }

        Borrow borrow = returned.getBorrow();

        LocalDate borrowedReturnDate = borrow.getReturnDate();
        LocalDate effectiveReturnedDate = returned.getEffectiveReturnDate();

        int dateDiff = (int) ChronoUnit.DAYS.between(borrowedReturnDate, effectiveReturnedDate);
        dateDiff = Math.max(dateDiff, 0); // pas de retard si négatif

        double amount = dateDiff * SANCTION_PER_DAY;

        Sanction sanction = new Sanction();
        sanction.setAmount(amount);
        sanction.setStatus(dateDiff > 0 ? SanctionStatus.UNPAID : SanctionStatus.PAID);
        sanction.setReturned(returned);

        return sanction;
    }
}
