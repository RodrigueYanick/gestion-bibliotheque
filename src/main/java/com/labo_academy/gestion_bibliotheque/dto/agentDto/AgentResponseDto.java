package com.labo_academy.gestion_bibliotheque.dto.agentDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersResponseDto;

import com.labo_academy.gestion_bibliotheque.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter

public class AgentResponseDto extends UsersResponseDto {


    public AgentResponseDto(Long id, String lastName, String firstName, LocalDate birthDate, String email, String address, Role role) {
        super(id, lastName, firstName, birthDate, email, address, role);
    }
}
