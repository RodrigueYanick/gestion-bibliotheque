package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryResponseDto;
import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Director;
import org.springframework.stereotype.Component;

@Component
public class DirectorMapper {

    // Conversion Entity to Dto
    public DirecteurResponseDto fromEntityToDto(Director director){
        return new DirecteurResponseDto(
                director.getId(),
                director.getLastName(),
                director.getFirstName(),
                director.getBirthDate(),
                director.getEmail(),
                director.getAddress(),
                director.getRole()
        );
    }

    // Conversion Dto To Entity
    public Director fromDtoToEntity(DirecteurCreateDto directeurCreateDto){
        Director director =  new Director();
        director.setLastName(directeurCreateDto.getLastName());
        director.setFirstName(directeurCreateDto.getFirstName());
        director.setBirthDate(directeurCreateDto.getBirthDate());
        director.setPassword(directeurCreateDto.getPassword());
        director.setEmail(directeurCreateDto.getEmail());
        director.setAddress(directeurCreateDto.getAddress());
        director.setRole(directeurCreateDto.getRole());
        return director;
    }
}
