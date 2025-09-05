package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {

    // Convertion d'une Entity en une DTO

    public DocumentResponseDto fromEntityToDto(Document document){
        return new DocumentResponseDto(
                document.getId(),
                document.getTitle(),
                document.getQuantity(),
                document.getPublicationDate(),
                document.getCreationDate(),
                document.getLastUpdateDate(),
                document.getisDeleted(),
                document.getImage(),
                document.getPublisher()
        );

    }


}
