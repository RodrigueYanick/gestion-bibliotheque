package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.entity.Dictionary;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class DictionaryMapper {

    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;

    // Conversion Entity and DTO
    public DictionaryResponseDto fromEntityToDto(Dictionary dictionary){
        Category category;
        Author author;
        return new DictionaryResponseDto(
              dictionary.getId(),
              dictionary.getTitle(),
              dictionary.getQuantity(),
              dictionary.getPublicationDate() ,
              dictionary.getCreationDate(),
              dictionary.getLastUpdateDate(),
              dictionary.getisDeleted(),
              dictionary.getImage(),
              dictionary.getPublisher(),
              dictionary.getCategory().getName(),
              dictionary.getAuthor().getFirstName(),
              dictionary.getLanguage(),
              dictionary.getNumberWords()
        );
    }

    // Convertion Dto en Entity
    public Dictionary fromDtoToEntity(DictionaryCreateDto dictionaryCreateDto){
        Dictionary dictionary = new Dictionary();
        dictionary.setTitle(dictionaryCreateDto.getTitle());
        dictionary.setQuantity(dictionaryCreateDto.getQuantity());
        dictionary.setPublicationDate(dictionaryCreateDto.getPublicationDate());
        dictionary.setDeleted(dictionaryCreateDto.getIsDeleted());
        dictionary.setImage(dictionaryCreateDto.getImage());
        dictionary.setPublisher(dictionaryCreateDto.getPublisher());
        Category category = categoryRepository.findByName(dictionaryCreateDto.getCategoryName());
        Author author = authorRepository.findByLastName(dictionaryCreateDto.getAuthorName());
        dictionary.setLanguage(dictionaryCreateDto.getLanguage());
        dictionary.setNumberWords(dictionaryCreateDto.getNumberWords());
        return dictionary;
    }
}
