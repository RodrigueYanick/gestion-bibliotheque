package com.labo_academy.gestion_bibliotheque.services;

import java.util.List;

import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.libraryClientDto.LibraryClientResponseDto;

public interface LibraryClientService {

    LibraryClientResponseDto create(LibraryClientCreateDto dto);
    List<LibraryClientResponseDto> findAll();
    LibraryClientResponseDto findById(Long id);
    LibraryClientResponseDto update(Long id, LibraryClientCreateDto dto);
    void delete(Long id);
    LibraryClientResponseDto upgradeToSubscriber(Long id, String accountNumber);

}
