package com.labo_academy.gestion_bibliotheque.services.serviceAgent;

import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Agent;
import com.labo_academy.gestion_bibliotheque.entity.Role;
import com.labo_academy.gestion_bibliotheque.mappers.AgentMapper;
import com.labo_academy.gestion_bibliotheque.repository.AgentRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements ServiceAgent {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private AgentMapper agentMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //  Creation d'un nouveau bibliothecaire
    @Override
    public AgentResponseDto createAgent(AgentCreateDto dto) {
        Agent agent = agentMapper.toEntity(dto);
        agent.setRole(Role.AGENT);
        agent.setPassword(passwordEncoder.encode(dto.getPassword()));
        Agent saved = agentRepository.save(agent);
        return agentMapper.toDto(saved);
    }

    //  Recuperer la liste de tous les bibliothecaires
    @Override
    public List<AgentResponseDto> getAllAgent() {
        List<Agent> agents = agentRepository.findAll();
        List<AgentResponseDto> dtos = new ArrayList<>();

        for (Agent lib : agents) {
            dtos.add(agentMapper.toDto(lib));
        }
        return dtos;
    }

    //  Recuperer un bibliothécaire par son ID
    @Override
    public AgentResponseDto getAgentById(long id) {
        Optional<Agent> agent = agentRepository.findById(id);
        if (agent.isPresent()) {
            return agentMapper.toDto(agent.get());
        }
        return null;
    }

    //  Mettre a jour un bibliothecaire existant
    @Override
    public AgentResponseDto update(Long id, AgentCreateDto dto) {
        Optional<Agent> agent = agentRepository.findById(id);
        if (agent.isPresent()) {
            Agent agent1 = agent.get();
            agent1.setLastName(dto.getLastName());
            agent1.setFirstName(dto.getFirstName());
            agent1.setBirthDate(dto.getBirthDate());
            agent1.setEmail(dto.getEmail());
            agent1.setAddress(dto.getAddress());
            agent1.setImageUrl(dto.getImageUrl());
            agent1.setIdNumber(dto.getIdNumber());

            // Réencoder le mot de passe seulement s'il est modifie
            agent1.setPassword(passwordEncoder.encode(dto.getPassword()));

            Agent updated = agentRepository.save(agent1);
            return agentMapper.toDto(updated);
        }
        return null;
    }

    //  Vérifie si un bibliothecaire existe par ID
    @Override
    public boolean existsById(long id) {
        return agentRepository.existsById(id);
    }

    //  Supprimer un bibliothecaire par ID
    @Override
    public void deleteById(long id) {
        agentRepository.deleteById(id);
    }
    
}
