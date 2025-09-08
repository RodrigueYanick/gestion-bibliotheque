package com.labo_academy.gestion_bibliotheque.dto.agentDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class AgentCreateDto extends UsersCreateDto {

    @NotBlank(message = "Le numéro de pièce d'identité est obligatoire")
    private String idNumber;

    public AgentCreateDto(String lastName, String firstName, LocalDate birthDate, String password, String email, String address, Role role, String imageURL, String idNumber) {
        super(lastName, firstName, birthDate, password, email, address, role, imageURL);
        this.idNumber = idNumber;
    }
}
