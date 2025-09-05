package com.labo_academy.gestion_bibliotheque.dto.agentDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;

import com.labo_academy.gestion_bibliotheque.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

public class AgentCreateDto extends UsersCreateDto {
@Getter
@Setter
    private String idNumber;

    public AgentCreateDto(String lastName, String firstName, LocalDate birthDate, String password, String email, String address, Role role,String idNumber) {
        super(lastName, firstName, birthDate, password, email, address, role);
        this.idNumber = idNumber;
    }
}
