package com.labo_academy.gestion_bibliotheque.dto.directorDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class DirectorCreateDto extends UsersCreateDto {

    @NotBlank(message = "Le numéro de pièce d'identité est obligatoire")
    private String idNumber;
    public DirectorCreateDto(String lastName, String firstName, LocalDate birthDate, String password, String email, String address, String imageURL, String idNumber) {
        super(lastName, firstName, birthDate, password, email, address, imageURL);
        this.idNumber = idNumber;
    }
}
