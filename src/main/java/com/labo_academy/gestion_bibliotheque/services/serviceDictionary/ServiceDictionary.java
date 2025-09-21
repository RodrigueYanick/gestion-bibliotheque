package com.labo_academy.gestion_bibliotheque.services.serviceDictionary;

import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryResponseDto;

import java.util.List;

public interface ServiceDictionary {

    public DictionaryResponseDto createDictionary(DictionaryCreateDto dictionaryCreateDto);
    public List<DictionaryResponseDto> getAllDictionary();
    public DictionaryResponseDto getDictionaryById(long id);
    public DictionaryResponseDto update(Long id, DictionaryCreateDto dto);

    public boolean existsById (long id);
    public  void deleteById(long id);
}
