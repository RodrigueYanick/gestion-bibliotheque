package com.labo_academy.gestion_bibliotheque.dto.librarianDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;

import com.labo_academy.gestion_bibliotheque.entity.Role;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class LibrarianCreateDto extends UsersCreateDto {

    @NotBlank(message = "Le numéro de pièce d'identité est obligatoire")
    private String idNumber;

    public LibrarianCreateDto(String lastName, String firstName, LocalDate birthDate, String password, String email, String address, Role role, String imageURL, String idNumber) {
        super(lastName, firstName, birthDate, password, email, address, role, imageURL);
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
