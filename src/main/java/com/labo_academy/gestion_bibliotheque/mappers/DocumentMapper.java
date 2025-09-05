package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.entity.Document;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DocumentMapper {

    /*
    CategoryRepository categoryRepository ;
    AuthorRepository authorRepository;

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

     */


}
