package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    // Conversion Entity To Dto
    public AuthorResponseDto fromEntityToDto(Author author){
        return new AuthorResponseDto(
                author.getAuthorId(),
                author.getLastName(),
                author.getFirstName(),
                author.getImmatriculation(),
                author.getNationality()
        );
    }

    // conversion dto To Entity
    public Author fromDtoToEntity(AuthorCreateDto authorCreateDto){
        Author author = new Author();
        author.setLastName(authorCreateDto.getLastName());
        author.setFirstName(authorCreateDto.getFirstName());
        author.setImmatriculation(authorCreateDto.getImmatriculation());
        author.setNationality(authorCreateDto.getNationalite());
        return author;
    }
}
