package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Librarian;
import org.springframework.stereotype.Component;

@Component
public class LibrarianMapper {

    // Conversion entity To Dto
    public LibrarianResponseDto fromEntityToDto(Librarian librarian){
        return new LibrarianResponseDto(
                librarian.getId(),
                librarian.getLastName(),
                librarian.getFirstName(),
                librarian.getBirthDate(),
                librarian.getEmail(),
                librarian.getAddress(),
                librarian.getRole()
        );
    }

    // Conversion Dto To entity
    public Librarian fromDtoToEntity(LibrarianCreateDto librarianCreateDto){
        Librarian librarian = new Librarian();
        librarian.setLastName(librarianCreateDto.getLastName());
        librarian.setFirstName(librarianCreateDto.getFirstName());
        librarian.setBirthDate(librarianCreateDto.getBirthDate());
        librarian.setPassword(librarianCreateDto.getPassword());
        librarian.setEmail(librarian.getEmail());
        librarian.setAddress(librarian.getEmail());
        librarian.setRole(librarianCreateDto.getRole());
        return librarian;
    }
}
