package com.labo_academy.gestion_bibliotheque.services.serviceAgent;

import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Agent;
import com.labo_academy.gestion_bibliotheque.mappers.AgentMapper;
import com.labo_academy.gestion_bibliotheque.repository.AgentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

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
        List<Agent> agents = agentRepository.findAll();
        if(agents.isEmpty()){throw new RuntimeException("Aucun Agent trouver.");}
        List<AgentResponseDto> agentResponseDtos = new ArrayList<>();
        for (Agent agent : agents) {
            agentResponseDtos.add(agentMapper.toDto(agent));
        }
        return agentResponseDtos;
    }

    @Override
    public AgentResponseDto getAgentById(Long id) {
        Agent agent = agentRepository.findById(id).orElseThrow(()-> new RuntimeException("Visiteur introuvable"));
        return agentMapper.toDto(agent);
           }

    @Override
    public AgentResponseDto update(Long id, AgentCreateDto dto) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent non trouvé avec l’ID : " + id));
        agent.setLastName(dto.getLastName());
        agent.setFirstName(dto.getFirstName());
        agent.setBirthDate(dto.getBirthDate());
        agent.setEmail(dto.getEmail());
        agent.setAddress(dto.getAddress());
        return agentMapper.toDto(agentRepository.save(agent));
    }


    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        if (!agentRepository.existsById(id)){
            System.out.println(" l'agent n'existe pas");
        }
        agentRepository.deleteById(id);
        return null;
    }

}
