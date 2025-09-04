package com.labo_academy.gestion_bibliotheque.dto.subscriberDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class SubscriberCreateDto extends UsersCreateDto {

    private String idNumber;
    private boolean statut;

}
