package com.labo_academy.gestion_bibliotheque.services.serviceDirector;

import com.labo_academy.gestion_bibliotheque.dto.directorDto.DirectorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.directorDto.DirectorResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Director;
import com.labo_academy.gestion_bibliotheque.entity.Director;
import com.labo_academy.gestion_bibliotheque.entity.Role;
import com.labo_academy.gestion_bibliotheque.mappers.DirectorMapper;
import com.labo_academy.gestion_bibliotheque.repository.DirectorRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service                       // Indique à Spring que cette classe est un service
@AllArgsConstructor        // Génère automatiquement un constructeur avec les attributs "final"
public class ServiceDirectorImpl implements ServiceDirector {

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private DirectorMapper directorMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //  Creation d'un nouveau bibliothecaire
    @Override
    public DirectorResponseDto createDirector(DirectorCreateDto dto) {
        Director director = directorMapper.toEntity(dto);
        director.setRole(Role.DIRECTOR);
        director.setPassword(passwordEncoder.encode(dto.getPassword()));
        Director saved = directorRepository.save(director);
        return directorMapper.toDto(saved);
    }

    //  Recuperer la liste de tous les bibliothecaires
    @Override
    public List<DirectorResponseDto> getAllDirector() {
        List<Director> directors = directorRepository.findAll();
        List<DirectorResponseDto> dtos = new ArrayList<>();

        for (Director direct : directors) {
            dtos.add(directorMapper.toDto(direct));
        }
        return dtos;
    }

    //  Recuperer un bibliothécaire par son ID
    @Override
    public DirectorResponseDto getDirectorById(long id) {
        Optional<Director> director = directorRepository.findById(id);
        if (director.isPresent()) {
            return directorMapper.toDto(director.get());
        }
        return null;
    }

    //  Mettre a jour un bibliothecaire existant
    @Override
    public DirectorResponseDto update(Long id, DirectorCreateDto dto) {
        Optional<Director> directors = directorRepository.findById(id);
        if (directors.isPresent()) {
            Director director = directors.get();
            director.setLastName(dto.getLastName());
            director.setFirstName(dto.getFirstName());
            director.setBirthDate(dto.getBirthDate());
            director.setEmail(dto.getEmail());
            director.setAddress(dto.getAddress());
            director.setImageUrl(dto.getImageUrl());
            director.setIdNumber(dto.getIdNumber());

            // Réencoder le mot de passe seulement s'il est modifie
            director.setPassword(passwordEncoder.encode(dto.getPassword()));

            Director updated = directorRepository.save(director);
            return directorMapper.toDto(updated);
        }
        return null;
    }

    //  Vérifie si un bibliothecaire existe par ID
    @Override
    public boolean existsById(long id) {
        return directorRepository.existsById(id);
    }

    //  Supprimer un bibliothecaire par ID
    @Override
    public void deleteById(long id) {
        directorRepository.deleteById(id);
    }
    
}
