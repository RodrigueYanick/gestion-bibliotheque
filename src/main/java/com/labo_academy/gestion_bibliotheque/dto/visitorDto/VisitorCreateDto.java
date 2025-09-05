package com.labo_academy.gestion_bibliotheque.dto.visitorDto;


import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;

import java.time.LocalDate;

public class VisitorCreateDto extends UsersCreateDto {

    private boolean statut;

    public VisitorCreateDto(String lastName, String firstName, LocalDate birthDate, String password, String email, String address, Role role, boolean statut) {
        super(lastName, firstName, birthDate, password, email, address, role);
        this.statut = statut;
    }
}
