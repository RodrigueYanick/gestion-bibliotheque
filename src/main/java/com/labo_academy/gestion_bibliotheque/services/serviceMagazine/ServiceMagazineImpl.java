package com.labo_academy.gestion_bibliotheque.services.serviceMagazine;

import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Magazine;
import com.labo_academy.gestion_bibliotheque.mappers.MagazineMapper;
import com.labo_academy.gestion_bibliotheque.repository.MagazineRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class ServiceMagazineImpl implements ServiceMagazine{

    private MagazineMapper magazineMapper;
    private MagazineRepository magazineRepository;

    @Override
    public MagazineResponseDto createMagazine(MagazineCreateDto magazineCreateDto) {
        Magazine magazine = magazineMapper.toEntity(magazineCreateDto);
        magazineRepository.save(magazine);
        return magazineMapper.toDto(magazine);
    }

    @Override
    public List<MagazineResponseDto> getAllMagazine() {
        List<Magazine> magazineList = magazineRepository.findAll();
        if(magazineList.isEmpty()){throw new RuntimeException("Aucun Magazine trouver.");}
        List<MagazineResponseDto> magazineResponseDtos = new ArrayList<>();
        for (Magazine magazine : magazineList) {
            magazineResponseDtos.add(magazineMapper.toDto(magazine));
        }
        return magazineResponseDtos;     }

    @Override
    public MagazineResponseDto getMagazineById(long id) {
        Magazine magazine = magazineRepository.findById(id).orElseThrow(()-> new RuntimeException("Magazine introuvable"));
        return magazineMapper.toDto(magazine);
    }

    @Override
    public MagazineResponseDto update(Long id, MagazineCreateDto dto) {
        Magazine magazine = magazineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author non trouvé avec l’ID : " + id));
        magazine.setIssn(dto.getIssn());
        return magazineMapper.toDto(magazineRepository.save(magazine));
    }

    @Override
    public boolean existsById(long id) {
        return magazineRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!magazineRepository.existsById(id)){
            System.out.println("le magazine n'existe pas");
        }
        magazineRepository.deleteById(id);
    }
}
