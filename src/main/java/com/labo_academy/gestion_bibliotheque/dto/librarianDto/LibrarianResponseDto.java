package com.labo_academy.gestion_bibliotheque.dto.librarianDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersResponseDto;

import com.labo_academy.gestion_bibliotheque.entity.Role;

import java.time.LocalDate;

public class LibrarianResponseDto extends UsersResponseDto {

    public LibrarianResponseDto(Long id, String lastName, String firstName, LocalDate birthDate, String email, String address, Role role) {
        super(id, lastName, firstName, birthDate, email, address, role);
    }
}
