package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.Returned;
import com.labo_academy.gestion_bibliotheque.entity.Sanction;
import com.labo_academy.gestion_bibliotheque.entity.SanctionStatus;
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
        return new SanctionResponseDto(
                sanction.getId(),
                sanction.getAmount(),
                sanction.getSanctionNumber(),
                sanction.getStatus()
        );
    }

    // ===== Returned -> Sanction (calcul automatique) =====
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
        sanction.setStatus(dateDiff > 0 ? SanctionStatus.UNPAID : SanctionStatus.PAID); // si pas de retard => payé d’office
        sanction.setReturned(returned);

        return sanction;
    }

    // ===== CreateDto -> Entity (si besoin manuel) =====
    public Sanction toEntity(SanctionCreateDto dto, Returned returned) {
        if (dto == null || returned == null) {
            return null;
        }
        Sanction sanction = new Sanction();
        sanction.setSanctionNumber(dto.getSanctionNumber());
        sanction.setStatus(SanctionStatus.UNPAID);
        sanction.setReturned(returned);
        return sanction;
    }
}
