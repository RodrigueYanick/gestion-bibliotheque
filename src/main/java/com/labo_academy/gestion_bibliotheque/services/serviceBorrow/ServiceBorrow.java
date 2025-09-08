package com.labo_academy.gestion_bibliotheque.services.serviceBorrow;

import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowResponseDto;

import java.util.List;

public interface ServiceBorrow {

    // CRUD sur l'emprunt
    public BorrowResponseDto createBorrow(BorrowCreateDto borrowCreateDto);
    public List<BorrowResponseDto> getAllBorrow();
    public BorrowResponseDto getBorrowById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);

}
