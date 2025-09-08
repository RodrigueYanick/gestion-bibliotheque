package com.labo_academy.gestion_bibliotheque.services.libraryClientService;

import java.util.List;

import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientResponseDto;

public interface LibraryClientService {

    public LibraryClientResponseDto create(LibraryClientCreateDto dto);
    public List<LibraryClientResponseDto> findAll();
    public LibraryClientResponseDto findById(Long id);
    public LibraryClientResponseDto update(Long id, LibraryClientCreateDto dto);
    public void delete(Long id);
    public LibraryClientResponseDto upgradeToSubscriber(Long id, String accountNumber);

}
