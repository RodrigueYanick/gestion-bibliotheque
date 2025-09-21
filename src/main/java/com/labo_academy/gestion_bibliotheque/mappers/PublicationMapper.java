package com.labo_academy.gestion_bibliotheque.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.entity.Publication;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;

@Component
public class PublicationMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // Entity -> ResponseDto
    public PublicationResponseDto toDto(Publication publication) {
        if (publication == null) {
            return null;
        }

        PublicationResponseDto dto = new PublicationResponseDto();
        dto.setId(publication.getId());
        dto.setTitle(publication.getTitle());
        dto.setDocumentNumber(publication.getDocumentNumber());
        dto.setPublicationDate(publication.getPublicationDate());
        dto.setCreationDate(publication.getCreationDate());
        dto.setLastUpdateDate(publication.getLastUpdateDate());
        dto.setDeleted(publication.isDeleted());
        dto.setImageUrl(publication.getImageUrl());
        dto.setPublisher(publication.getPublisher());
        dto.setCategoryName(publication.getCategory().getName());
        dto.setAuthorName(publication.getAuthor().getLastName());

        // Champ spécifique
        dto.setUniversite(publication.getUniversity());

        return dto;
    }

    // CreateDto -> Entity
    public Publication toEntity(PublicationCreateDto dto) {
        if (dto == null) {
            return null;
        }

        Publication publication = new Publication();
        publication.setTitle(dto.getTitle());
        publication.setPublicationDate(dto.getPublicationDate());
        publication.setPublisher(dto.getPublisher());
        publication.setUniversity(dto.getUniversite()); // mapping FR -> EN

        Category category = categoryRepository.findByName(dto.getCategoryName());
        if (category == null) {
            throw new RuntimeException("Catégorie introuvable : " + dto.getCategoryName());
        }

        Author author = authorRepository.findByImmatriculation(dto.getImmatriculation());
        if (author == null) {
            throw new RuntimeException("Auteur introuvable : " + dto.getImmatriculation());
        }

        publication.setCategory(category);
        publication.setAuthor(author);

        return publication;
    }
}
