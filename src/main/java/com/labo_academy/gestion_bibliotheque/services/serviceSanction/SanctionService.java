package com.labo_academy.gestion_bibliotheque.services.serviceSanction;

import java.util.List;

import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionResponseDto;

public interface SanctionService {

    SanctionResponseDto create(SanctionCreateDto dto);
    List<SanctionResponseDto> findAll();
    SanctionResponseDto findById(Long id);
    SanctionResponseDto updateStatus(Long id, String status);
    void delete(Long id);

}
