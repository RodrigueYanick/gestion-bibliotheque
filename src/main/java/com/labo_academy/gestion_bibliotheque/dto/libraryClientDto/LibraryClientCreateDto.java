package com.labo_academy.gestion_bibliotheque.dto.libraryClientDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;

@Getter
@Setter
// @NoArgsConstructor
// @AllArgsConstructor
public class LibraryClientCreateDto extends UsersCreateDto {

    // Champs spécifiques au VISITOR par defaut actif dès la creation
    // private Boolean visitorStatus = true;

}
