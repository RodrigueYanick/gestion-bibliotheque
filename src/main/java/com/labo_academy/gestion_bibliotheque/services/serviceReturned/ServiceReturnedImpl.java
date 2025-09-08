package com.labo_academy.gestion_bibliotheque.services.serviceReturned;

import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Returned;
import com.labo_academy.gestion_bibliotheque.mappers.ReturnedMapper;
import com.labo_academy.gestion_bibliotheque.repository.ReturnedRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceReturnedImpl implements ServiceReturned{

    private ReturnedMapper retuernedMapper;
    private ReturnedRepository returnedRepository;

    @Override
    public ReturnedResponseDto createReturned(ReturnedCreateDto returnedCreateDto) {
        Returned returned = retuernedMapper.toEntity(returnedCreateDto);
        returnedRepository.save(returned);
        return retuernedMapper.toDto(returned);
    }

    @Override
    public List<ReturnedResponseDto> getAllReturned() {
        return returnedRepository.findAll().stream().map(retuernedMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ReturnedResponseDto getReturnedById(long id) {
        Returned returned = returnedRepository.findById(id).orElseThrow(()-> new RuntimeException(" introuvable"));
        return retuernedMapper.toDto(returned);
    }

    @Override
    public boolean existsById(long id) {
        return returnedRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!returnedRepository.existsById(id)){
            System.out.println(" n'existe pas");
        }
        returnedRepository.deleteById(id);
    }
}
