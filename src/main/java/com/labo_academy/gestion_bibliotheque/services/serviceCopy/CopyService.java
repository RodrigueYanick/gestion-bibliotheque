package com.labo_academy.gestion_bibliotheque.services.serviceCopy;

import java.util.List;

import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyResponseDto;

public interface CopyService {

    CopyResponseDto create(CopyCreateDto dto);
    List<CopyResponseDto> findAll();
    CopyResponseDto findById(Long id);
    List<CopyResponseDto> findByDocumentMatricule(String matricule);
    List<CopyResponseDto> findByDocumentTitle(String title);
    void delete(Long id);

}
