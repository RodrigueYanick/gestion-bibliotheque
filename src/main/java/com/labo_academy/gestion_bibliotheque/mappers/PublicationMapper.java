package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.entity.Publication;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class PublicationMapper {

    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;
    // Conversion Entity To Dto
    public PublicationResponseDto fromEntityTpDto(Publication publication){
        Category category;
        Author author;
        return new PublicationResponseDto(
                publication.getId(),
                publication.getTitle(),
                publication.getQuantity(),
                publication.getPublicationDate(),
                publication.getCreationDate(),
                publication.getLastUpdateDate(),
                publication.getisDeleted(),
                publication.getImage(),
                publication.getCategory().getName(),
                publication.getAuthor().getFirstName(),
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
        Category category = categoryRepository.findByName(publicationCreateDto.getCategoryName());
        Author author = authorRepository.findByLastName(publicationCreateDto.getAuthorName());
        return publication;
    }
}
