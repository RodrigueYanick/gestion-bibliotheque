package com.labo_academy.gestion_bibliotheque.services.serviceLibrarian;

import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianResponseDto;

import java.util.List;

public interface ServiceLibrarian {
    public LibrarianResponseDto createLibrarian(LibrarianCreateDto librarianCreateDto);
    public List<LibrarianResponseDto> getAllLibrarian();
    public LibrarianResponseDto getLibrarianById(long id);
    public LibrarianResponseDto update(Long id, LibrarianCreateDto dto);
    public boolean existsById (long id);
    public  void deleteById(long id);

}
