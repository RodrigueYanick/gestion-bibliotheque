package com.labo_academy.gestion_bibliotheque.services.serviceReturnedBill;

import java.util.List;

import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillResponseDto;

public interface ReturnedBillService {

    ReturnedBillResponseDto create(ReturnedBillCreateDto dto);
    List<ReturnedBillResponseDto> findAll();
    ReturnedBillResponseDto findById(Long id);
    void delete(Long id);

}
