package com.labo_academy.gestion_bibliotheque.services.serviceCopy;

import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Copy;
import com.labo_academy.gestion_bibliotheque.mappers.CopyMapper;
import com.labo_academy.gestion_bibliotheque.repository.CopyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class ServiceCopyImpl implements ServiceCopy{

    CopyMapper copyMapper;
    CopyRepository copyRepository;

    @Override
    public CopyResponseDto createCopy(CopyCreateDto copyCreateDto) {
        Copy copy = copyMapper.toEntity(copyCreateDto);
        copyRepository.save(copy);
        return copyMapper.toDto(copy);    }

    @Override
    public List<CopyResponseDto> getAllCopy() {
        List<Copy> copyList = copyRepository.findAll();
        if(copyList.isEmpty()){throw new RuntimeException("Aucune Copy trouver.");}
        List<CopyResponseDto> copyResponseDtos = new ArrayList<>();
        for (Copy copy : copyList) {
            copyResponseDtos.add(copyMapper.toDto(copy));
        }
        return copyResponseDtos;         }

    @Override
    public CopyResponseDto getCopyById(long id) {
        Copy copy = copyRepository.findById(id).orElseThrow(()-> new RuntimeException("Copy introuvable"));
        return copyMapper.toDto(copy);    }

    @Override
    public CopyResponseDto update(Long id, CopyCreateDto dto) {
        Copy copy = copyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Copy non trouvé avec l’ID : " + id));
        return copyMapper.toDto(copyRepository.save(copy));    }

    @Override
    public boolean existsById(long id) {
        return copyRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!copyRepository.existsById(id)){
            throw new RuntimeException("la Cpie n'existe pas");
        }
        copyRepository.deleteById(id);
    }
}
