package com.labo_academy.gestion_bibliotheque.mappers;

import org.springframework.stereotype.Component;

import com.labo_academy.gestion_bibliotheque.dto.directorDto.DirectorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.directorDto.DirectorResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Director;

@Component
public class DirectorMapper {

    // Entity -> ResponseDto
    public DirectorResponseDto toDto(Director director) {
        if (director == null) {
            return null;
        }

        return new DirectorResponseDto(
            director.getId(),
            director.getLastName(),
            director.getFirstName(),
            director.getBirthDate(),
            director.getEmail(),
            director.getAddress(),
            director.getRole(),
            director.getImageUrl(),
            director.getIdNumber()
        );
    }

    // CreateDto -> Entity
    public Director toEntity(DirectorCreateDto dto) {
        if (dto == null) {
            return null;
        }

        Director director = new Director();
        director.setLastName(dto.getLastName());
        director.setFirstName(dto.getFirstName());
        director.setBirthDate(dto.getBirthDate());
        director.setPassword(dto.getPassword());
        director.setEmail(dto.getEmail());
        director.setAddress(dto.getAddress());
        director.setRole(dto.getRole());
        director.setImageUrl(dto.getImageUrl());
        director.setIdNumber(dto.getIdNumber());                     

        return director;
    }
}
