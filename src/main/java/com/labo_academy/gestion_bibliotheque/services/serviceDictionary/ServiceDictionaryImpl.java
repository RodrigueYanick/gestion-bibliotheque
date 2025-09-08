package com.labo_academy.gestion_bibliotheque.services.serviceDictionary;

import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.dictionaryDto.DictionaryResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Dictionary;
import com.labo_academy.gestion_bibliotheque.mappers.DictionaryMapper;
import com.labo_academy.gestion_bibliotheque.repository.DictionaryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceDictionaryImpl implements ServiceDictionary{

    private DictionaryMapper dictionaryMapper;
    private DictionaryRepository dictionaryRepository;
    @Override
    public DictionaryResponseDto createDictionary(DictionaryCreateDto dictionaryCreateDto) {
        Dictionary dictionary = dictionaryMapper.toEntity(dictionaryCreateDto);
        dictionaryRepository.save(dictionary);
        return dictionaryMapper.toDto(dictionary);
    }

    @Override
    public List<DictionaryResponseDto> getAllCategory() {
        return dictionaryRepository.findAll().stream().map(dictionaryMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public DictionaryResponseDto getCategoryById(long id) {
        Dictionary dictionary = dictionaryRepository.findById(id).orElseThrow(()-> new RuntimeException("Dictionnaire introuvable"));
        return dictionaryMapper.toDto(dictionary);    }

    @Override
    public boolean existsById(long id) {
        return dictionaryRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!dictionaryRepository.existsById(id)){
            System.out.println("le dictionnaire n'existe pas");
        }
        dictionaryRepository.deleteById(id);
    }
}
