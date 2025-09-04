package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Agent;
import org.springframework.stereotype.Component;

@Component
public class AgentMapper {

    // Conversion Entity To Dto
    public AgentResponseDto fromEntityToDto(Agent agent){
        return  new AgentResponseDto(
                agent.getId(),
                agent.getLastName(),
                agent.getFirstName(),
                agent.getBirthDate(),
                agent.getEmail(),
                agent.getAddress(),
                agent.getRole()
        );
    }

    // Conversion Dto To Entity
    public Agent fromDtoToEntity(AgentCreateDto agentCreateDto){
        Agent agent = new Agent();
        agent.setLastName(agentCreateDto.getLastName());
        agent.setFirstName(agentCreateDto.getFirstName());
        agent.setBirthDate(agentCreateDto.getBirthDate());
        agent.setPassword(agentCreateDto.getPassword());
        agent.setEmail(agentCreateDto.getEmail());
        agent.setAddress(agentCreateDto.getAddress());
        agent.setRole(agentCreateDto.getRole());
        return agent;
    }
}
