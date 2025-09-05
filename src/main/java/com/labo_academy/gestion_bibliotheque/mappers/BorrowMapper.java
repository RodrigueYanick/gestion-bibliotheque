package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import com.labo_academy.gestion_bibliotheque.entity.Subscribers;
import com.labo_academy.gestion_bibliotheque.repository.DocumentRepository;
import com.labo_academy.gestion_bibliotheque.repository.SubscribersRepository;
import org.springframework.stereotype.Component;

@Component
public class BorrowMapper {

    private DocumentRepository documentRepository;
    private SubscribersRepository subscribersRepository;

    // Conversion Entity To Dto
    public BorrowResponseDto fromEntityToDto(Borrow borrow){
        return new BorrowResponseDto(
                borrow.getBorrowedId(),
                borrow.getStatus(),
                borrow.getBorrowedDate(),
                borrow.getReturnDate(),
                borrow.getDocument().getMatricule(),
                borrow.getSuscriber().getEmail()
        );
    }

    // Conversion Dto To Entity
    public Borrow fromDtoToEntity(BorrowCreateDto borrowCreateDto){
        Borrow borrow = new Borrow();
        borrow.setStatus(borrowCreateDto.getStatus());
        Document documents = documentRepository.findByTitle(borrowCreateDto.getDocumentTitle());
        Document document = documentRepository.findByMatricule(borrowCreateDto.getDocumentTitle());
        Subscribers subscribers = subscribersRepository.findByEmail(borrowCreateDto.getSuscribersEmail());

        return borrow;
    }
}
