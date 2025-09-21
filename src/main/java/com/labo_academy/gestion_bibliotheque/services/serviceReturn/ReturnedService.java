package com.labo_academy.gestion_bibliotheque.services.serviceReturn;

import java.util.List;

import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedResponseDto;

public interface ReturnedService {

    ReturnedResponseDto create(ReturnedCreateDto dto);
    List<ReturnedResponseDto> findAll();
    ReturnedResponseDto findById(Long id);
    void delete(Long id);

}
