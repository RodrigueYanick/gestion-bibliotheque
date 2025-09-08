package com.labo_academy.gestion_bibliotheque.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Copy;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import com.labo_academy.gestion_bibliotheque.repository.DocumentRepository;

@Component
public class CopyMapper {

    @Autowired
    private DocumentRepository documentRepository;

    // Entity -> ResponseDto
    public CopyResponseDto toDto(Copy copy) {
        if (copy == null) {
            return null;
        }
        return new CopyResponseDto(
                copy.getId(),
                copy.isBorrowed(),
                copy.getDocument().getDocumentNumber(),
                copy.getDocument().getTitle()
        );
    }

    // CreateDto -> Entity
    public Copy toEntity(CopyCreateDto dto) {
        if (dto == null) {
            return null;
        }
        Document document = documentRepository.findById(dto.getDocumentId())
                .orElseThrow(() -> new RuntimeException(
                        "Document introuvable avec id : " + dto.getDocumentId()
                ));

        Copy copy = new Copy();
        copy.setBorrowed(dto.getIsBorrowed());
        copy.setDocument(document);
        return copy;
    }
}
