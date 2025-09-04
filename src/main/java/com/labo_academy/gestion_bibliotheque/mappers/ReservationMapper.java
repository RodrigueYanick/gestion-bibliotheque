package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Reservation;
import com.labo_academy.gestion_bibliotheque.entity.Returned;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    // Conversion Entity To Dto
    public ReservationResponseDto fromEntityToDt(Reservation reservation){
        return new ReservationResponseDto(
                reservation.getReservationId(),
                reservation.getReservationDate(),
                reservation.isStatut()
        );
    }

    // Conversion Dto To Entity
    public Reservation fromDtoToEntity(ReservationCreateDto reservationCreateDto){
        Reservation reservation =  new Reservation();
        reservation.setReservationDate(reservationCreateDto.getReservationDate());
        reservation.setStatut(reservationCreateDto.isStatut());
        return reservation;
    }
}
