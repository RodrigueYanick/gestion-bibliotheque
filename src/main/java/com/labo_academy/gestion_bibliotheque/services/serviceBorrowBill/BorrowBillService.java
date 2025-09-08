package com.labo_academy.gestion_bibliotheque.services.serviceBorrowBill;

import java.util.List;

import com.labo_academy.gestion_bibliotheque.dto.borrowBillDto.BorrowedBillResponseDto;

public interface BorrowBillService {

    BorrowedBillResponseDto create(Long borrowId);

    List<BorrowedBillResponseDto> findAll();

    BorrowedBillResponseDto findById(Long id);

    void delete(Long id);
    
}
