package com.labo_academy.gestion_bibliotheque.services.servicePublication;

import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Publication;
import com.labo_academy.gestion_bibliotheque.mappers.PublicationMapper;
import com.labo_academy.gestion_bibliotheque.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service

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
        List<Publication> publicationsList = publicationRepository.findAll();
        if(publicationsList.isEmpty()){throw new RuntimeException("Aucun Auteur trouver.");}
        List<PublicationResponseDto> publicationResponseDtos = new ArrayList<>();
        for (Publication publication : publicationsList) {
            publicationResponseDtos.add(publicationMapper.toDto(publication));
        }
        return publicationResponseDtos;     }

    @Override
    public PublicationResponseDto getPublicationById(long id) {
        Publication publication = publicationRepository.findById(id).orElseThrow(()-> new RuntimeException("Publication introuvable"));
        return publicationMapper.toDto(publication);
    }

    @Override
    public PublicationResponseDto update(Long id, PublicationCreateDto dto) {
        Publication publication = publicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication non trouvé avec l’ID : " + id));
        publication.setUniversity(dto.getUniversite());
        return publicationMapper.toDto(publicationRepository.save(publication));
    }

    @Override
    public boolean existsById(long id) {
        return publicationRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!publicationRepository.existsById(id)){
            throw new RuntimeException("la publication n'existe pas");
        }
        publicationRepository.deleteById(id);
    }
}
