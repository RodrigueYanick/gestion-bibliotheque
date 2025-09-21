package com.labo_academy.gestion_bibliotheque.dto.librarianDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LibrarianResponseDto extends UsersResponseDto {

    @NotBlank(message = "Le numéro de pièce d'identité est obligatoire")
    private String idNumber;

    public LibrarianResponseDto(Long id, String lastName, String firstName,
                                LocalDate birthDate, String email, String address,
                                Role role, String imageUrl,
                                String idNumber) {
        // Appel du constructeur parent (UsersResponseDto)
        super(id, lastName, firstName, birthDate, email, address, role, imageUrl);

        // Champ spécifique au bibliothécaire
        this.idNumber = idNumber;
    }
}
