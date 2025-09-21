package com.labo_academy.gestion_bibliotheque.services.serviceAuthor;

import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.authorDto.AuthorResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import com.labo_academy.gestion_bibliotheque.mappers.AuthorMapper;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

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
        List<Author> authors = authorRepository.findAll();
        if(authors.isEmpty()){throw new RuntimeException("Aucun Auteur trouver.");}
        List<AuthorResponseDto> authorResponseDtoList = new ArrayList<>();
        for (Author author : authors) {
            authorResponseDtoList.add(authorMapper.fromEntityToDto(author));
        }
        return authorResponseDtoList;    }

    @Override
    public AuthorResponseDto getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new RuntimeException("l'auteur introuvable"));
        return authorMapper.fromEntityToDto(author);     }

    @Override
    public AuthorResponseDto update(Long id, AuthorCreateDto dto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author non trouvé avec l’ID : " + id));
        author.setLastName(dto.getLastName());
        author.setFirstName(dto.getFirstName());
        author.setNationality(dto.getNationality());
        return authorMapper.fromEntityToDto(authorRepository.save(author));
    }

    @Override
    public boolean existsById(long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!authorRepository.existsById(id)){
            throw new RuntimeException("l'auteur non trouvé avec l’ID : " + id);
        }
        authorRepository.deleteById(id);
    }
}
