package com.labo_academy.gestion_bibliotheque.dto.visitorDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class VisitorCreateDto extends UsersCreateDto {

    private boolean statut;

}
