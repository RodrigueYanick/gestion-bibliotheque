package com.labo_academy.gestion_bibliotheque.services.serviceDirector;

import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Director;
import com.labo_academy.gestion_bibliotheque.mappers.DirectorMapper;
import com.labo_academy.gestion_bibliotheque.repository.DirectorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceDirectorImpl implements ServiceDirector{

    private DirectorRepository directorRepository;
    private  DirectorMapper directorMapper;
    @Override
    public DirecteurResponseDto createDirecteur(DirecteurCreateDto directeurCreateDto) {
        Director director = directorMapper.toEntity(directeurCreateDto);
        directorRepository.save(director);
        return directorMapper.toDto(director);

    }

    @Override
    public List<DirecteurResponseDto> getAllDirecteur() {
        return directorRepository.findAll().stream().map(directorMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public DirecteurResponseDto getDirecteurById(long id) {
        Director director = directorRepository.findById(id).orElseThrow(()-> new RuntimeException("directeur introuvable"));
        return directorMapper.toDto(director);
    }

    @Override
    public boolean existsById(long id) {
        return directorRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!directorRepository.existsById(id)){
            System.out.println("le directeur n'existe pas");
        }
        directorRepository.deleteById(id);
    }
}
