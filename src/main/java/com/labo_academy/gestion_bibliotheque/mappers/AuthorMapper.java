package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    // Conversion Entity -> ResponseDto
    public AuthorResponseDto fromEntityToDto(Author author) {
        if (author == null) {
            return null;
        }
        return new AuthorResponseDto(
                author.getAuthorId(),
                author.getLastName(),
                author.getFirstName(),
                author.getImmatriculation(),
                author.getNationality()
        );
    }

    // Conversion CreateDto -> Entity
    public Author fromDtoToEntity(AuthorCreateDto dto) {
        if (dto == null) {
            return null;
        }
        Author author = new Author();
        author.setLastName(dto.getLastName());
        author.setFirstName(dto.getFirstName());
        author.setImmatriculation(dto.getImmatriculation());
        author.setNationality(dto.getNationality());
        return author;
    }
}
