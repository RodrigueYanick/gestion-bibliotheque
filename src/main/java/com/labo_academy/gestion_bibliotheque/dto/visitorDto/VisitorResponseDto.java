package com.labo_academy.gestion_bibliotheque.dto.visitorDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersResponseDto;

import com.labo_academy.gestion_bibliotheque.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class VisitorResponseDto extends UsersResponseDto {


    public VisitorResponseDto(Long id, String lastName, String firstName, LocalDate birthDate, String email, String address, Role role) {
        super(id, lastName, firstName, birthDate, email, address, role);
    }
}
