package com.labo_academy.gestion_bibliotheque.dto.publicationDto;


import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentResponseDto;

import java.time.LocalDate;

public class PublicationResponseDto extends DocumentResponseDto {

    private String universite;


    public PublicationResponseDto(Long id, String title, int quantity, LocalDate publicationDate, LocalDate creationDate, LocalDate lastUpdateDate, boolean isDeleted, byte[] image, String publisher, String categoryName, String authorName,String universite) {
        super(id, title, quantity, publicationDate, creationDate, lastUpdateDate, isDeleted, image, publisher, categoryName, authorName);
        this.universite = universite;
    }
}
