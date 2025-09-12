package com.labo_academy.gestion_bibliotheque.controllers;

import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentResponseDto;
import com.labo_academy.gestion_bibliotheque.services.serviceAgent.ServiceAgent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agent")
public class AgentController {

    @Autowired
    private ServiceAgent serviceAgent;

    //  Creer un nouvel agent
    @PostMapping("/create")
    public ResponseEntity<AgentResponseDto> createAgent(@RequestBody AgentCreateDto dto) {
        AgentResponseDto created = serviceAgent.createAgent(dto);
        return ResponseEntity.ok(created);
    }

    //  Recuperer tous les agents
    @GetMapping("/all")
    public ResponseEntity<List<AgentResponseDto>> getAllAgents() {
        List<AgentResponseDto> list = serviceAgent.getAllAgent();
        return ResponseEntity.ok(list);
    }

    //  Recuperer un agent par son ID
    @GetMapping("/{id}")
    public ResponseEntity<AgentResponseDto> getAgentById(@PathVariable Long id) {
        AgentResponseDto dto = serviceAgent.getAgentById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    //  Mettre à jour un agent existant
    @PutMapping("/update/{id}")
    public ResponseEntity<AgentResponseDto> updateAgent(@PathVariable Long id,
                                                        @RequestBody AgentCreateDto dto) {
        AgentResponseDto updated = serviceAgent.update(id, dto);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    //  Supprimer un agent par son ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable Long id) {
        if (!serviceAgent.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        serviceAgent.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
