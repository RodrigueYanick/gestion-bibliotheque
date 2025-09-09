package com.labo_academy.gestion_bibliotheque.services.serviceCopy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.copyDto.CopyResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Copy;
import com.labo_academy.gestion_bibliotheque.mappers.CopyMapper;
import com.labo_academy.gestion_bibliotheque.repository.CopyRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class CopyServiceImpl implements CopyService {

    private final CopyRepository copyRepository;
    private final CopyMapper copyMapper;

    @Override
    public CopyResponseDto create(CopyCreateDto dto) {
        Copy copy = copyMapper.toEntity(dto);
        return copyMapper.toDto(copyRepository.save(copy));
    }

    @Override
    public List<CopyResponseDto> findAll() {
        List<Copy> copys = copyRepository.findAll();
        if (copys.isEmpty()) {
            throw new RuntimeException("Aucune Copy trouvee.");
        }
        List<CopyResponseDto> copyDtos = new ArrayList<>();
        for (Copy copy : copys) {
            copyDtos.add(copyMapper.toDto(copy));
        }
        return copyDtos;
    }

    @Override
    public CopyResponseDto findById(Long id) {
        Copy copy = copyRepository.findById(id).orElseThrow(() -> new RuntimeException("Copie introuvable avec l'ID : " + id));
        return copyMapper.toDto(copy);
    }

    @Override
    public List<CopyResponseDto> findByDocumentMatricule(String matricule) {
        List<Copy> copys = copyRepository.findByDocument_DocumentNumber(matricule);
        if (copys.isEmpty()) {
            throw new RuntimeException("Aucune Copy trouvee.");
        }
        List<CopyResponseDto> copyDtos = new ArrayList<>();
        for (Copy copy : copys) {
            copyDtos.add(copyMapper.toDto(copy));
        }
        return copyDtos;
    }

    @Override
    public List<CopyResponseDto> findByDocumentTitle(String title) {
        List<Copy> copys = copyRepository.findByDocument_Title(title);
        if (copys.isEmpty()) {
            throw new RuntimeException("Aucune Copy trouvee.");
        }
        List<CopyResponseDto> copyDtos = new ArrayList<>();
        for (Copy copy : copys) {
            copyDtos.add(copyMapper.toDto(copy));
        }
        return copyDtos;
    }

    @Override
    public void delete(Long id) {
        if (!copyRepository.existsById(id)) {
            throw new RuntimeException("Copie introuvable avec l'ID : " + id);
        }
        copyRepository.deleteById(id);
    }

}
