package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.BorrowedStatus;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import com.labo_academy.gestion_bibliotheque.entity.LibraryClient;
import com.labo_academy.gestion_bibliotheque.repository.DocumentRepository;
import com.labo_academy.gestion_bibliotheque.repository.LibraryClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BorrowMapper {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private LibraryClientRepository subscribersRepository;

    // Convertir Entity -> DTO
    public BorrowResponseDto fromEntityToDto(Borrow borrow) {
        if (borrow == null) {
            return null;
        }
        return new BorrowResponseDto(
                borrow.getBorrowedId(),
                borrow.getStatus(),
                borrow.getBorrowedDate(),
                borrow.getReturnDate(),
                borrow.getDocument().getDocumentNumber(),
                borrow.getSubscriber().getEmail()
        );
    }

    // Convertir DTO -> Entity
    public Borrow fromDtoToEntity(BorrowCreateDto dto) {
        if (dto == null) {
            return null;
        }

        // Vérifier l’existence du document
        Document document = documentRepository.findByDocumentNumber(dto.getDocumentMatricule());
        if (document == null) {
            throw new RuntimeException("Document introuvable : " + dto.getDocumentMatricule());
        }

        // Vérifier l’existence de l’abonné
        LibraryClient subscriber = subscribersRepository.findByEmail(dto.getSubscribersEmail());
        if (subscriber == null) {
            throw new RuntimeException("Utilisateur introuvable : " + dto.getSubscribersEmail());
        }

        // Création de l’objet Borrow
        Borrow borrow = new Borrow();
        borrow.setDocument(document);
        borrow.setSubscriber(subscriber);

        // Valeurs par défaut
        borrow.setStatus(BorrowedStatus.IN_PROGRESS);
        borrow.setBorrowedDate(LocalDate.now());
        borrow.setReturnDate(LocalDate.now().plusDays(10));

        return borrow;
    }

}
