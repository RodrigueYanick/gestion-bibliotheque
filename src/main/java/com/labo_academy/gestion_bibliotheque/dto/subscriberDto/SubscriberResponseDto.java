package com.labo_academy.gestion_bibliotheque.dto.subscriberDto;


import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;

import java.time.LocalDate;

public class SubscriberResponseDto extends UsersResponseDto {


    public SubscriberResponseDto(Long id, String lastName, String firstName, LocalDate birthDate, String email, String address, Role role) {
        super(id, lastName, firstName, birthDate, email, address, role);
    }
}
