package com.labo_academy.gestion_bibliotheque.dto.directeurDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class DirecteurCreateDto extends UsersCreateDto {

    private String idNumber;
    public DirecteurCreateDto(String lastName, String firstName, LocalDate birthDate, String password, String email, String address, Role role,String idNumber) {
        super(lastName, firstName, birthDate, password, email, address, role);
        this.idNumber = idNumber;
    }
}
