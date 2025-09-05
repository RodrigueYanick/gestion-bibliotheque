package com.labo_academy.gestion_bibliotheque.dto.publicationDto;


import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;

import java.time.LocalDate;

public class PublicationCreateDto extends DocumentCreateDto {

    private String universite;


    public PublicationCreateDto(String title, int quantity, LocalDate publicationDate, boolean isDeleted, byte[] image, String publisher, String categoryName, String authorName,String universite) {
        super(title, quantity, publicationDate, isDeleted, image, publisher, categoryName, authorName);
        this.universite = universite;
    }
}
