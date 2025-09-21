package com.labo_academy.gestion_bibliotheque.services.serviceSanctionBill;

import java.util.List;

import com.labo_academy.gestion_bibliotheque.dto.sanctionBillDto.SanctionBillResponseDto;

public interface SanctionBillService {

    SanctionBillResponseDto create(Long sanctionId);
    List<SanctionBillResponseDto> getAll();
    SanctionBillResponseDto getById(Long id);
    void delete(Long id);

}
