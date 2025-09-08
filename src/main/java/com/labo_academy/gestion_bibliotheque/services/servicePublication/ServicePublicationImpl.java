package com.labo_academy.gestion_bibliotheque.services.servicePublication;

import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Publication;
import com.labo_academy.gestion_bibliotheque.mappers.PublicationMapper;
import com.labo_academy.gestion_bibliotheque.repository.PublicationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ServicePublicationImpl implements ServicePublication{

    private PublicationRepository publicationRepository;
    private PublicationMapper publicationMapper;

    @Override
    public PublicationResponseDto createPublication(PublicationCreateDto publicationCreateDto) {
        Publication publication = publicationMapper.toEntity(publicationCreateDto);
        publicationRepository.save(publication);
        return publicationMapper.toDto(publication);
    }

    @Override
    public List<PublicationResponseDto> getAllPublication() {
        return publicationRepository.findAll().stream().map(publicationMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PublicationResponseDto getPublicationById(long id) {
        Publication publication = publicationRepository.findById(id).orElseThrow(()-> new RuntimeException("Publication introuvable"));
        return publicationMapper.toDto(publication);
    }

    @Override
    public boolean existsById(long id) {
        return publicationRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!publicationRepository.existsById(id)){
            System.out.println("la publication n'existe pas");
        }
        publicationRepository.deleteById(id);
    }
}
