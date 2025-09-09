package com.labo_academy.gestion_bibliotheque.services.serviceAgent;

import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentResponseDto;

import java.util.List;

public interface ServiceAgent {

    // gestion de son propre compte
    public AgentResponseDto createAgent(AgentCreateDto agentCreateDto);
    public List<AgentResponseDto> getAllAgent();
    public AgentResponseDto getAgentById(Long id);
    public AgentResponseDto update(Long id, AgentCreateDto dto);
    public AgentResponseDto deleteById(Long id);

}
