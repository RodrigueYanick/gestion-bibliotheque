package com.labo_academy.gestion_bibliotheque.services.serviceMagazine;

import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineResponseDto;

import java.util.List;

public interface ServiceMagazine {

    // CRUD Magasine
    public MagazineResponseDto createMagazine(MagazineCreateDto magazineCreateDto);
    public List<MagazineResponseDto> getAllMagazine();
    public MagazineResponseDto getMagazineById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
