package com.labo_academy.gestion_bibliotheque.services.serviceReservation;

import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Reservation;
import com.labo_academy.gestion_bibliotheque.mappers.ReservationMapper;
import com.labo_academy.gestion_bibliotheque.repository.ReservationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceReservationImpl implements ServiceReservation{

    private ReservationRepository reservationRepository;
    private ReservationMapper reservationMapper;

    @Override
    public ReservationResponseDto createReservation(ReservationCreateDto reservationCreateDto) {
        Reservation reservation = reservationMapper.toEntity(reservationCreateDto);
        reservationRepository.save(reservation);
        return reservationMapper.toDto(reservation);
    }

    @Override
    public List<ReservationResponseDto> getAllReservation() {
        return reservationRepository.findAll().stream().map(reservationMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ReservationResponseDto getReservationById(long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()-> new RuntimeException("reservation introuvable"));
        return reservationMapper.toDto(reservation);
    }

    @Override
    public boolean existsById(long id) {
        return reservationRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!reservationRepository.existsById(id)){
            System.out.println("la reservation n'existe pas");
        }
        reservationRepository.deleteById(id);
    }
}
