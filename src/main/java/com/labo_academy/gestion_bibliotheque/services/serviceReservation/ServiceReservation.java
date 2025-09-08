package com.labo_academy.gestion_bibliotheque.services.serviceReservation;

import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationResponseDto;

import java.util.List;

public interface ServiceReservation {

    public ReservationResponseDto createReservation(ReservationCreateDto reservationCreateDto);
    public List<ReservationResponseDto> getAllReservation();
    public ReservationResponseDto getReservationById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
    
}
