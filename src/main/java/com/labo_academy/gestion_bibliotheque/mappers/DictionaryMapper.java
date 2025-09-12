package com.labo_academy.gestion_bibliotheque.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.entity.Dictionary;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;

@Component
public class DictionaryMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // Entity -> ResponseDto
    public DictionaryResponseDto toDto(Dictionary dictionary) {
        if (dictionary == null) {
            return null;
        }

        DictionaryResponseDto dto = new DictionaryResponseDto();
        dto.setId(dictionary.getId());  // hérité de Document
        dto.setTitle(dictionary.getTitle());
        dto.setDocumentNumber(dictionary.getDocumentNumber());
        dto.setPublicationDate(dictionary.getPublicationDate());
        dto.setCreationDate(dictionary.getCreationDate());
        dto.setLastUpdateDate(dictionary.getLastUpdateDate());
        dto.setDeleted(dictionary.isDeleted());
        dto.setImageUrl(dictionary.getImageUrl());
        dto.setPublisher(dictionary.getPublisher());
        dto.setCategoryName(dictionary.getCategory().getName());
        dto.setAuthorName(dictionary.getAuthor().getLastName());

        // Champs spécifiques
        dto.setLanguage(dictionary.getLanguage());
        dto.setNumberWords(dictionary.getNumberWords());

        return dto;
    }

    // CreateDto -> Entity
    public Dictionary toEntity(DictionaryCreateDto dto) {
        if (dto == null) {
            return null;
        }

        Dictionary dictionary = new Dictionary();
        dictionary.setTitle(dto.getTitle());
        dictionary.setPublicationDate(dto.getPublicationDate());
        dictionary.setPublisher(dto.getPublisher());
        dictionary.setLanguage(dto.getLanguage());
        dictionary.setNumberWords(dto.getNumberWords());
        Category category = categoryRepository
        .findByName(dto.getCategoryName());
        if(category == null){ new RuntimeException("Catégorie introuvable : " + dto.getCategoryName());}

        Author author = authorRepository
        .findByLastName(dto.getAuthorName());
        if(author == null){ new RuntimeException("Auteur introuvable : " + dto.getAuthorName());};

        dictionary.setCategory(category);
        dictionary.setAuthor(author);
        return dictionary;
    }
}
