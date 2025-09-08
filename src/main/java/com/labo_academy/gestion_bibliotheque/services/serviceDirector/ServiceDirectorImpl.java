package com.labo_academy.gestion_bibliotheque.services.serviceDirector;

import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Director;
import com.labo_academy.gestion_bibliotheque.mappers.DirectorMapper;
import com.labo_academy.gestion_bibliotheque.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

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
        List<Director> directorList = directorRepository.findAll();
        if(directorList.isEmpty()){throw new RuntimeException("Aucun Directeur trouver.");}
        List<DirecteurResponseDto> directeurResponseDtos = new ArrayList<>();
        for (Director director : directorList) {
            directeurResponseDtos.add(directorMapper.toDto(director));
        }
        return directeurResponseDtos;
    }

    @Override
    public DirecteurResponseDto getDirecteurById(long id) {
        Director director = directorRepository.findById(id).orElseThrow(()-> new RuntimeException("directeur introuvable"));
        return directorMapper.toDto(director);
    }

    @Override
    public DirecteurResponseDto update(Long id, DirecteurCreateDto dto) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author non trouvé avec l’ID : " + id));
        director.setLastName(dto.getLastName());
        director.setFirstName(dto.getFirstName());
        director.setBirthDate(dto.getBirthDate());
        director.setEmail(dto.getEmail());
        return directorMapper.toDto(directorRepository.save(director));
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
