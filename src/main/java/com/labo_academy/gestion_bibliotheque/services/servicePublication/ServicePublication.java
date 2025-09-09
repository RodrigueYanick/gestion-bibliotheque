package com.labo_academy.gestion_bibliotheque.services.servicePublication;

import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.publicationDto.PublicationResponseDto;

import java.util.List;

public interface ServicePublication {

    // CRUD sur la Publication
    public PublicationResponseDto createPublication(PublicationCreateDto publicationCreateDto);
    public List<PublicationResponseDto> getAllPublication();
    public PublicationResponseDto getPublicationById(long id);
    public PublicationResponseDto update(Long id, PublicationCreateDto dto);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
