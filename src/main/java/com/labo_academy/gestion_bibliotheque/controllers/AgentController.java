package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentResponseDto;
import com.labo_academy.gestion_bibliotheque.repository.AgentRepository;
import com.labo_academy.gestion_bibliotheque.services.serviceAgent.ServiceAgent;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/agent")
public class AgentController {

    @Autowired
    private AgentRepository AgentRepository;

    @Autowired
    private ServiceAgent serviceAgent;

    @PostMapping("/create")
    public ResponseEntity<AgentResponseDto> createAgent(@Valid @RequestBody AgentCreateDto AgentCreateDto){
        AgentResponseDto createdAgent = serviceAgent.createAgent(AgentCreateDto);
        return new ResponseEntity<>(createdAgent, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<AgentResponseDto>> getAllAgent(){
        return ResponseEntity.ok(serviceAgent.getAllAgent());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AgentResponseDto> update(@PathVariable Long id, @Valid @RequestBody AgentCreateDto dto) {
        AgentResponseDto updatedAgent = serviceAgent.update(id, dto);
        return ResponseEntity.ok(updatedAgent); // retourne 200 OK avec l'objet mis à jour
    }


    @GetMapping("{id}")
    public ResponseEntity<AgentResponseDto> getAgentById(@PathVariable Long id){
        return ResponseEntity.ok(serviceAgent.getAgentById(id));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        serviceAgent.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
