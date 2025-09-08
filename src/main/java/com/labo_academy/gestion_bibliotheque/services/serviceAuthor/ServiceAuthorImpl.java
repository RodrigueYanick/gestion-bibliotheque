package com.labo_academy.gestion_bibliotheque.services.serviceAuthor;

import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import com.labo_academy.gestion_bibliotheque.mappers.AuthorMapper;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceAuthorImpl implements ServiceAuthor{

    private AuthorMapper authorMapper;
    private AuthorRepository authorRepository;

    @Override
    public AuthorResponseDto createAuthor(AuthorCreateDto authorCreateDto) {
        Author author = authorMapper.fromDtoToEntity(authorCreateDto);
        authorRepository.save(author);
        return authorMapper.fromEntityToDto(author);
    }

    @Override
    public List<AuthorResponseDto> getAllAuthor() {
        return authorRepository.findAll().stream().map(authorMapper::fromEntityToDto).collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDto getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new RuntimeException("l'auteur introuvable"));
        return authorMapper.fromEntityToDto(author);     }

    @Override
    public boolean existsById(long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!authorRepository.existsById(id)){
            System.out.println("l'auteur n'existe pas");
        }
        authorRepository.deleteById(id);
    }
}
