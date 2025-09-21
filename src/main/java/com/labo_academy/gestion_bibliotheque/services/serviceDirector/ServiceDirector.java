package com.labo_academy.gestion_bibliotheque.services.serviceDirector;

import java.util.List;

import com.labo_academy.gestion_bibliotheque.dto.directorDto.DirectorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.directorDto.DirectorResponseDto;

public interface ServiceDirector {

    public DirectorResponseDto createDirector(DirectorCreateDto dto);
    public List<DirectorResponseDto> getAllDirector();
    public DirectorResponseDto getDirectorById(long id);
    public DirectorResponseDto update(Long id, DirectorCreateDto dto);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
