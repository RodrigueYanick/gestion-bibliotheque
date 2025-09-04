package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Publication;
import org.springframework.stereotype.Component;

@Component
public class PublicationMapper {

    // Conversion Entity To Dto
    public PublicationResponseDto fromEntityTpDto(Publication publication){
        return new PublicationResponseDto(
                publication.getId(),
                publication.getTitle(),
                publication.getQuantity(),
                publication.getPublicationDate(),
                publication.getCreationDate(),
                publication.getLastUpdateDate(),
                publication.getisDeleted(),
                publication.getImage(),
                publication.getPublisher(),
                publication.getUniversity()
        );
    }

    // conversion Dto To Entity
    public Publication fromDtoToEntity(PublicationCreateDto publicationCreateDto){
        Publication publication = new Publication();
        publication.setTitle(publicationCreateDto.getTitle());
        publication.setQuantity(publicationCreateDto.getQuantity());
        publication.setPublicationDate(publication.getPublicationDate());
        publication.setDeleted(publicationCreateDto.getIsDeleted());
        publication.setImage(publicationCreateDto.getImage());
        publication.setPublisher(publicationCreateDto.getPublisher());
        return publication;
    }
}
