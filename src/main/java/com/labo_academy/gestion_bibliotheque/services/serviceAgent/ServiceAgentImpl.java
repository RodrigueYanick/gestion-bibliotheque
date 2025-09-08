package com.labo_academy.gestion_bibliotheque.services.serviceAgent;

import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Agent;
import com.labo_academy.gestion_bibliotheque.mappers.AgentMapper;
import com.labo_academy.gestion_bibliotheque.repository.AgentRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceAgent.ServiceAgent;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceAgentImpl implements ServiceAgent {

    private AgentRepository agentRepository;
    private AgentMapper agentMapper;

    @Override
    public AgentResponseDto createAgent(AgentCreateDto agentCreateDto) {
        Agent agent = agentMapper.toEntity(agentCreateDto);
        agentRepository.save(agent);
        return agentMapper.toDto(agent);    }

    @Override
    public List<AgentResponseDto> getAllAgent() {
        return agentRepository.findAll().stream().map(agentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AgentResponseDto getAgentById(Long id) {
        Agent agent = agentRepository.findById(id).orElseThrow(()-> new RuntimeException("Visiteur introuvable"));
        return agentMapper.toDto(agent);
           }

    @Override
    public boolean existssById(Long id) {
        return agentRepository.existsById(id);
    }

    @Override
    public void deletesById(Long id) {
        if (!agentRepository.existsById(id)){
            System.out.println(" l'agent n'existe pas");
        }
        agentRepository.deleteById(id);
    }

}
