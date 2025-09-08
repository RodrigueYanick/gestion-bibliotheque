package com.labo_academy.gestion_bibliotheque.services.serviceLibrarian;

<<<<<<< HEAD
import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.directeurDto.DirecteurResponseDto;
import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentResponseDto;
import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianResponseDto;

import java.util.List;

=======
>>>>>>> e6a4eb49e23673d9eab285385c8e5178a10f282b
public interface ServiceLibrarian {
    public LibrarianResponseDto createLibrarian(LibrarianCreateDto librarianCreateDto);
    public List<LibrarianResponseDto> getAllLibrarian();
    public LibrarianResponseDto getLibrarianById(long id);
    public LibrarianResponseDto update(Long id, LibrarianCreateDto dto);
    public boolean existsById (long id);
    public  void deleteById(long id);

}
