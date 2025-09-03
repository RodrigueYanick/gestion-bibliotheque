package com.labo_academy.gestion_bibliotheque.dto.agentDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AgentCreateDto extends UsersCreateDto {

    private String idNumber;

}
