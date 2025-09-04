package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Dictionary;
import org.springframework.stereotype.Component;

@Component
public class DictionaryMapper {

    // Conversion Entity and DTO
    public DictionaryResponseDto fromEntityToDto(Dictionary dictionary){
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
        dictionary.setLanguage(dictionaryCreateDto.getLanguage());
        dictionary.setNumberWords(dictionaryCreateDto.getNumberWords());
        return dictionary;
    }
}
