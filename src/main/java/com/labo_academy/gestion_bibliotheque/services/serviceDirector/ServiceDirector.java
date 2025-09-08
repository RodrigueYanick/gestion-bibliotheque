package com.labo_academy.gestion_bibliotheque.services.serviceDirector;

import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurResponseDto;

import java.util.List;

public interface ServiceDirector {

    public DirecteurResponseDto createDirecteur(DirecteurCreateDto directeurCreateDto);
    public List<DirecteurResponseDto> getAllDirecteur();
    public DirecteurResponseDto getDirecteurById(long id);
    public DirecteurResponseDto update(Long id, DirecteurCreateDto dto);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
