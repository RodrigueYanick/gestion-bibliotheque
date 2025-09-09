package com.labo_academy.gestion_bibliotheque.services.serviceReturned;

import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedResponseDto;

import java.util.List;

public interface ServiceReturned {

    // CRUD Retuerned
    public ReturnedResponseDto createReturned(ReturnedCreateDto returnedCreateDto);
    public List<ReturnedResponseDto> getAllReturned();
    public ReturnedResponseDto getReturnedById(long id);
    public ReturnedResponseDto update(Long id, ReturnedCreateDto dto);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
