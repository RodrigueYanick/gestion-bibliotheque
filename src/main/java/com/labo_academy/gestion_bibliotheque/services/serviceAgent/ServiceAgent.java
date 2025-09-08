package com.labo_academy.gestion_bibliotheque.services.serviceAgent;

import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentResponseDto;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======

>>>>>>> e6a4eb49e23673d9eab285385c8e5178a10f282b

import java.util.List;

public interface ServiceAgent {

    // gestion de son propre compte
    public AgentResponseDto createAgent(AgentCreateDto agentCreateDto);
    public List<AgentResponseDto> getAllAgent();
    public AgentResponseDto getAgentById(Long id);
    public AgentResponseDto update(Long id, AgentCreateDto dto);
    public ResponseEntity<Void> deleteById(Long id);

}
