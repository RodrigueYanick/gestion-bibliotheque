package com.labo_academy.gestion_bibliotheque.services.libraryClientService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.LibraryClient;
import com.labo_academy.gestion_bibliotheque.mappers.LibraryClientMapper;
import com.labo_academy.gestion_bibliotheque.repository.LibraryClientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class LibraryClientServiceImpl implements LibraryClientService {

    private LibraryClientRepository libraryClientRepository;
    private LibraryClientMapper libraryClientMapper;

    @Override
    public LibraryClientResponseDto create(LibraryClientCreateDto dto) {
        LibraryClient client = libraryClientMapper.toEntity(dto);
        return libraryClientMapper.toDto(libraryClientRepository.save(client));
    }

    @Override
    public List<LibraryClientResponseDto> findAll() {
        List<LibraryClient> libraryClients = libraryClientRepository.findAll();
        if(libraryClients.isEmpty()){throw new RuntimeException("Aucun administrateur trouver.");}
        List<LibraryClientResponseDto> libraryClientDtos = new ArrayList<>();
        for (LibraryClient libraryClient : libraryClients) {
            libraryClientDtos.add(libraryClientMapper.toDto(libraryClient));
        }
        return libraryClientDtos;
    }

    @Override
    public LibraryClientResponseDto findById(Long id) {
        LibraryClient client = libraryClientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouve avec l’ID : " + id));
        return libraryClientMapper.toDto(client);
    }

    @Override
    public LibraryClientResponseDto update(Long id, LibraryClientCreateDto dto) {
        LibraryClient client = libraryClientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l’ID : " + id));

        client.setLastName(dto.getLastName());
        client.setFirstName(dto.getFirstName());
        client.setBirthDate(dto.getBirthDate());
        client.setEmail(dto.getEmail());
        client.setAddress(dto.getAddress());

        return libraryClientMapper.toDto(libraryClientRepository.save(client));
    }

    @Override
    public void delete(Long id) {
        if (!libraryClientRepository.existsById(id)) {
            throw new RuntimeException("Client non trouvé avec l’ID : " + id);
        }
        libraryClientRepository.deleteById(id);
    }

    @Override
    public LibraryClientResponseDto upgradeToSubscriber(Long id, String accountNumber) {
        LibraryClient client = libraryClientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l’ID : " + id));

        client.upgradeToSubscriber(accountNumber);
        return libraryClientMapper.toDto(libraryClientRepository.save(client));
    }

}
