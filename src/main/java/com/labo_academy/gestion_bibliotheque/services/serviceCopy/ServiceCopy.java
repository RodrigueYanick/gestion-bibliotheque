package com.labo_academy.gestion_bibliotheque.services.serviceCopy;

import com.labo_academy.gestion_bibliotheque.dto.categoryDto.CategoryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyResponseDto;

import java.util.List;

public interface ServiceCopy {

    // CRUD Copy
    public CopyResponseDto createCopy(CopyCreateDto copyCreateDto);
    public List<CopyResponseDto> getAllCopy();
    public CopyResponseDto getCopyById(long id);
    public CopyResponseDto update(Long id, CopyCreateDto dto);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
