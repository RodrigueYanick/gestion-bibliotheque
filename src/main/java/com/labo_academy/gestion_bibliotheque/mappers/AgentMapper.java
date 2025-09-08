package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Agent;
import org.springframework.stereotype.Component;

@Component
public class AgentMapper {

    // Entity -> DTO
    public AgentResponseDto toDto(Agent agent) {
        if (agent == null) return null;

        return new AgentResponseDto(
                agent.getId(),
                agent.getLastName(),
                agent.getFirstName(),
                agent.getBirthDate(),
                agent.getEmail(),
                agent.getAddress(),
                agent.getRole(),
                agent.getImageUrl(),   // 👉 l’URL de l’image
                agent.getIdNumber()    // 👉 le numéro d’identité
        );
    }

    // ✅ DTO -> Entity
    public Agent toEntity(AgentCreateDto agentCreateDto) {
        if (agentCreateDto == null) return null;

        Agent agent = new Agent();
        agent.setLastName(agentCreateDto.getLastName());
        agent.setFirstName(agentCreateDto.getFirstName());
        agent.setBirthDate(agentCreateDto.getBirthDate());
        agent.setPassword(agentCreateDto.getPassword());
        agent.setEmail(agentCreateDto.getEmail());
        agent.setAddress(agentCreateDto.getAddress());
        agent.setRole(agentCreateDto.getRole());
        agent.setImageUrl(agentCreateDto.getImageUrl()); // 👉 récupère l’URL
        agent.setIdNumber(agentCreateDto.getIdNumber());

        return agent;
    }
}
