package com.labo_academy.gestion_bibliotheque.services.serviceDictionary;

import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryResponseDto;

import java.util.List;

public interface ServiceDictionary {

    public DictionaryResponseDto createDictionary(DictionaryCreateDto dictionaryCreateDto);
    public List<DictionaryResponseDto> getAllCategory();
    public DictionaryResponseDto getCategoryById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
