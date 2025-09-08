package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.reservationDto.ReservationResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import com.labo_academy.gestion_bibliotheque.entity.Reservation;
import com.labo_academy.gestion_bibliotheque.entity.LibraryClient;
import com.labo_academy.gestion_bibliotheque.repository.DocumentRepository;
import com.labo_academy.gestion_bibliotheque.repository.LibraryClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    @Autowired
    private LibraryClientRepository subscribersRepository;

    @Autowired
    private DocumentRepository documentRepository;

    // Entity -> ResponseDto
    public ReservationResponseDto toDto(Reservation reservation) {
        if (reservation == null) {
            return null;
        }

        return new ReservationResponseDto(
                reservation.getReservationId(),
                reservation.getReservationDate(),
                reservation.isActive(),
                reservation.getSubscriber().getEmail(),
                reservation.getDocument().getTitle(),
                reservation.getSubscriber().getCreationDate(),
                reservation.getSubscriber().getLastUpdate()
        );
    }

    // CreateDto -> Entity
    public Reservation toEntity(ReservationCreateDto dto) {
        if (dto == null) {
            return null;
        }

        Reservation reservation = new Reservation();
        reservation.setReservationDate(dto.getReservationDate());
        reservation.setActive(true); // une réservation est active par défaut

        LibraryClient subscriber = subscribersRepository.findByEmail(dto.getSubscribersEmail());
        if (subscriber == null) {
            throw new RuntimeException("Abonné introuvable avec l’email : " + dto.getSubscribersEmail());
        }

        Document document = documentRepository.findByTitle(dto.getDocumentTitle());
        if (document == null) {
            throw new RuntimeException("Document introuvable avec le titre : " + dto.getDocumentTitle());
        }

        reservation.setSubscriber(subscriber);
        reservation.setDocument(document);

        return reservation;
    }
}
