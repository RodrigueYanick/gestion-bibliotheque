package com.labo_academy.gestion_bibliotheque.dto.agentDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AgentResponseDto extends UsersResponseDto {

    private String idNumber;

    public AgentResponseDto(Long id, String lastName, String firstName,
                            LocalDate birthDate, String email, String address,
                            Role role, String imageUrl, String idNumber) {
        // 👇 on appelle bien le parent avec imageUrl
        super(id, lastName, firstName, birthDate, email, address, role, imageUrl);

        this.idNumber = idNumber;
    }
}
