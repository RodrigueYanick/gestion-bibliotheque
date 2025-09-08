package com.labo_academy.gestion_bibliotheque.dto.directeurDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class DirecteurCreateDto extends UsersCreateDto {

    @NotBlank(message = "Le numéro de pièce d'identité est obligatoire")
    private String idNumber;
    public DirecteurCreateDto(String lastName, String firstName, LocalDate birthDate, String password, String email, String address, Role role, String imageURL, String idNumber) {
        super(lastName, firstName, birthDate, password, email, address, role, imageURL);
        this.idNumber = idNumber;
    }
}
