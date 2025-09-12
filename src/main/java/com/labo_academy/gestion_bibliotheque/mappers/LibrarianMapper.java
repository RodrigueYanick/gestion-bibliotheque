package com.labo_academy.gestion_bibliotheque.mappers;

import org.springframework.stereotype.Component;

import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Librarian;

@Component
public class LibrarianMapper {

    // Entity -> ResponseDto
    public LibrarianResponseDto toDto(Librarian librarian) {
        if (librarian == null) {
            return null;
        }

        return new LibrarianResponseDto(
            librarian.getId(),
            librarian.getLastName(),
            librarian.getFirstName(),
            librarian.getBirthDate(),
            librarian.getEmail(),
            librarian.getAddress(),
            librarian.getRole(),
            librarian.getImageUrl(),
            librarian.getIdNumber()
        );
    }

    // CreateDto -> Entity
    public Librarian toEntity(LibrarianCreateDto dto) {
        if (dto == null) {
            return null;
        }

        Librarian librarian = new Librarian();
        librarian.setLastName(dto.getLastName());
        librarian.setFirstName(dto.getFirstName());
        librarian.setBirthDate(dto.getBirthDate());
        librarian.setPassword(dto.getPassword());
        librarian.setEmail(dto.getEmail());
        librarian.setAddress(dto.getAddress());
        librarian.setImageUrl(dto.getImageUrl());
        librarian.setIdNumber(dto.getIdNumber());

        return librarian;
    }
}
