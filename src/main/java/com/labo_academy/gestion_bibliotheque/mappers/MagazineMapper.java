package com.labo_academy.gestion_bibliotheque.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.entity.Magazine;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;

@Component
public class MagazineMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // Entity -> ResponseDto
    public MagazineResponseDto toDto(Magazine magazine) {
        if (magazine == null) {
            return null;
        }

        MagazineResponseDto dto = new MagazineResponseDto();
        dto.setId(magazine.getId());
        dto.setTitle(magazine.getTitle());
        dto.setDocumentNumber(magazine.getDocumentNumber());
        dto.setPublicationDate(magazine.getPublicationDate());
        dto.setCreationDate(magazine.getCreationDate());
        dto.setLastUpdateDate(magazine.getLastUpdateDate());
        dto.setDeleted(magazine.isDeleted());
        dto.setImageUrl(magazine.getImageUrl());
        dto.setPublisher(magazine.getPublisher());
        dto.setCategoryName(magazine.getCategory().getName());
        dto.setAuthorName(magazine.getAuthor().getLastName());

        // Champs spécifiques à Magazine
        dto.setIssn(magazine.getIssn());
        dto.setValidationPeriod(magazine.getPublicationFrequency()); 

        return dto;
    }

    // CreateDto -> Entity
    public Magazine toEntity(MagazineCreateDto dto) {
        if (dto == null) {
            return null;
        }

        Magazine magazine = new Magazine();
        magazine.setTitle(dto.getTitle());
        magazine.setPublicationDate(dto.getPublicationDate());
        magazine.setPublisher(dto.getPublisher());
        magazine.setIssn(dto.getIssn());
        magazine.setPublicationFrequency(dto.getValidationPeriod());

        Category category = categoryRepository.findByName(dto.getCategoryName());
        if (category == null) {
            throw new RuntimeException("Catégorie introuvable : " + dto.getCategoryName());
        }

        Author author = authorRepository.findByLastName(dto.getAuthorName());
        if (author == null) {
            throw new RuntimeException("Auteur introuvable : " + dto.getAuthorName());
        }

        magazine.setCategory(category);
        magazine.setAuthor(author);

        return magazine;
    }
}
