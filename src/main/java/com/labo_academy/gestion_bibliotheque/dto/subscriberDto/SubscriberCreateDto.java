package com.labo_academy.gestion_bibliotheque.dto.subscriberDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;

import java.time.LocalDate;

public class SubscriberCreateDto extends UsersCreateDto {

    private String idNumber;
    private boolean statut;

    public SubscriberCreateDto(String lastName, String firstName, LocalDate birthDate, String password, String email, String address,   Role role, String idNumber, boolean statut) {
        super(lastName, firstName, birthDate, password, email, address, role);
        this.idNumber = idNumber;
        this.statut = statut;
    }
}
