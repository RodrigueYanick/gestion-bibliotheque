package com.labo_academy.gestion_bibliotheque.services.serviceReservation;

import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Book;
import com.labo_academy.gestion_bibliotheque.entity.Reservation;
import com.labo_academy.gestion_bibliotheque.mappers.ReservationMapper;
import com.labo_academy.gestion_bibliotheque.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service

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
        List<Reservation> reservationList = reservationRepository.findAll();
        if(reservationList.isEmpty()){throw new RuntimeException("Aucune Reservation trouver.");}
        List<ReservationResponseDto> reservationResponseDtos = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            reservationResponseDtos.add(reservationMapper.toDto(reservation));
        }
        return reservationResponseDtos;     }

    @Override
    public ReservationResponseDto getReservationById(long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()-> new RuntimeException("reservation introuvable"));
        return reservationMapper.toDto(reservation);
    }

    @Override
    public ReservationResponseDto update(Long id, ReservationCreateDto dto) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation non trouvé avec l’ID : " + id));
        reservation.setReservationDate(dto.getReservationDate());
        return reservationMapper.toDto(reservationRepository.save(reservation));
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
