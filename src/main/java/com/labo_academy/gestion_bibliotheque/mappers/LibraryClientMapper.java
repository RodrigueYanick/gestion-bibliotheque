package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.LibraryClient;
import com.labo_academy.gestion_bibliotheque.entity.RoleClient;

public class LibraryClientMapper {

    
    // Convertit un CreateDto en entité LibraryClient.
    // Par défaut, un client est VISITOR à la création.
    
    public static LibraryClient toEntity(LibraryClientCreateDto dto) {
        if (dto == null) {
            return null;
        }

        LibraryClient client = new LibraryClient();
        client.setLastName(dto.getLastName());
        client.setFirstName(dto.getFirstName());
        client.setBirthDate(dto.getBirthDate());
        client.setPassword(dto.getPassword());
        client.setEmail(dto.getEmail());
        client.setAddress(dto.getAddress());
        client.setRole(dto.getRole());
        client.setImageUrl(dto.getImageUrl());

        // Règle métier : un nouveau client est VISITOR
        client.setRoleClient(RoleClient.VISITOR);
        client.setVisitorStatus(true);
        client.setSubscriberStatus(null);
        client.setAccountNumber(null);

        return client;
    }

    
    // Convertit une entité LibraryClient en ResponseDto.
    
    public static LibraryClientResponseDto toDto(LibraryClient client) {
        if (client == null) {
            return null;
        }

        return new LibraryClientResponseDto(
                client.getId(),
                client.getLastName(),
                client.getFirstName(),
                client.getBirthDate(),
                client.getEmail(),
                client.getAddress(),
                client.getRole(),
                client.getImageUrl(),
                client.getRoleClient(),
                client.getAccountNumber(),
                client.getSubscriberStatus(),
                client.getVisitorStatus()
        );
    }
}
