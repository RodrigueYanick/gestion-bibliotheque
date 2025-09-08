package com.labo_academy.gestion_bibliotheque.services.serviceAuthor;

import com.labo_academy.gestion_bibliotheque.dto.agentDto.AgentResponseDto;
import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorResponseDto;


import java.util.List;

public interface ServiceAuthor {

    // CRUD sur l'auteur
    public AuthorResponseDto createAuthor(AuthorCreateDto authorCreateDto);
    public List<AuthorResponseDto> getAllAuthor();
    public AuthorResponseDto getAuthorById(long id);
    public AuthorResponseDto update(Long id, AuthorCreateDto dto);
    public boolean existsById (long id);
    public void deleteById(long id);

}
