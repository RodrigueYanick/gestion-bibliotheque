package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import com.labo_academy.gestion_bibliotheque.entity.Reservation;
import com.labo_academy.gestion_bibliotheque.entity.Subscribers;
import com.labo_academy.gestion_bibliotheque.repository.DocumentRepository;
import com.labo_academy.gestion_bibliotheque.repository.SubscribersRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    DocumentRepository documentRepository;
    SubscribersRepository subscribersRepository;
    // Conversion Entity To Dto
    public ReservationResponseDto fromEntityToDt(Reservation reservation){
        Document document;
        Subscribers subscribers;
        return new ReservationResponseDto(
                reservation.getReservationId(),
                reservation.getReservationDate(),
                reservation.isStatut(),
                reservation.getAbonne().getEmail(),
                reservation.getDocuments().getTitle()
        );
    }

    // Conversion Dto To Entity
    public Reservation fromDtoToEntity(ReservationCreateDto reservationCreateDto){
        Reservation reservation =  new Reservation();
        reservation.setReservationDate(reservationCreateDto.getReservationDate());
        reservation.setStatut(reservationCreateDto.isStatut());
        Subscribers subscribers = subscribersRepository.findByEmail(reservationCreateDto.getSubscribersEmail());
        Document document = documentRepository.findByTitle(reservationCreateDto.getDocumentTitle());
        return reservation;
    }
}
