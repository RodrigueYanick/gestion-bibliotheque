package com.labo_academy.gestion_bibliotheque.dto.directeurDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DirecteurResponseDto extends UsersResponseDto {

    private String idNumber;

    public DirecteurResponseDto(Long id, String lastName, String firstName,
                                LocalDate birthDate, String email, String address,
                                Role role, String imageUrl, String idNumber) {
        // On appelle bien le constructeur parent avec imageUrl
        super(id, lastName, firstName, birthDate, email, address, role, imageUrl);

        // On initialise l’idNumber qui est spécifique au directeur
        this.idNumber = idNumber;
    }
}
