package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentResponseDto;
import com.labo_academy.gestion_bibliotheque.repository.AgentRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceAgent.ServiceAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/agent")
public class AgentController {

    @Autowired
    private ServiceAgent serviceAgent;

    @Autowired
    private AgentRepository agentRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createAgent(@RequestBody AgentCreateDto agentCreateDto){
        serviceAgent.createAgent(agentCreateDto);
        return ResponseEntity.ok("Agent creer avec succes");
    }

    @GetMapping("/")
    public List<AgentResponseDto> getAllAgent(){
        return serviceAgent.getAllAgent();
    }

    @GetMapping("/update/{id}/{agent}")
    public AgentResponseDto update(Long id, AgentCreateDto dto){
        return serviceAgent.update(id,dto);
    }

    @GetMapping("{id}")
    public AgentResponseDto getAgentById(@PathVariable Long id){
        return serviceAgent.getAgentById(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
       return serviceAgent.deleteById(id);
    }

}
