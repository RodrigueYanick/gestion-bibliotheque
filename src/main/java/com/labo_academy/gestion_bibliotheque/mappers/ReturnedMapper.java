package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import com.labo_academy.gestion_bibliotheque.entity.Returned;
import com.labo_academy.gestion_bibliotheque.entity.LibraryClient;
import com.labo_academy.gestion_bibliotheque.repository.BorrowRepository;
import com.labo_academy.gestion_bibliotheque.repository.DocumentRepository;
import com.labo_academy.gestion_bibliotheque.repository.LibraryClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReturnedMapper {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private LibraryClientRepository subscribersRepository;

    // Entity -> DTO
    public ReturnedResponseDto toDto(Returned returned) {
        if (returned == null) {
            return null;
        }
        return new ReturnedResponseDto(
                returned.getId(),
                returned.getEffectiveReturnDate()
        );
    }

    // DTO -> Entity
    public Returned toEntity(ReturnedCreateDto dto) {
        if (dto == null) {
            return null;
        }

        // On vérifie que l’abonné existe
        LibraryClient subscriber = subscribersRepository.findByEmail(dto.getReturnedEmail());
        if (subscriber == null) {
            throw new RuntimeException("Abonné introuvable avec email : " + dto.getReturnedEmail());
        }

        // On vérifie que le document existe
        Document document = documentRepository.findByDocumentNumber(dto.getDocumentMatricule());
        if (document == null) {
            throw new RuntimeException("Document introuvable avec matricule : " + dto.getDocumentMatricule());
        }

        // On récupère l’emprunt actif correspondant
        Borrow borrow = borrowRepository.findBySubscriberAndDocumentAndStatusActive(subscriber, document);
                if(borrow == null){
                    throw new RuntimeException("Aucun emprunt actif trouvé pour cet abonné et ce document");
                }    

        // Création de l’entité Returned
        Returned returned = new Returned();
        returned.setBorrow(borrow);
        returned.setReturnNumber("RET-" + System.currentTimeMillis()); // identifiant unique
        return returned;
    }
}
