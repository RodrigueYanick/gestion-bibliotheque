package com.labo_academy.gestion_bibliotheque.dto.publicationDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicationCreateDto extends DocumentCreateDto {

    private String universite;

    public PublicationCreateDto(String title, int quantity, LocalDate publicationDate, boolean isDeleted, byte[] image, String publisher,String universite) {
        super(title, quantity, publicationDate, isDeleted, image, publisher);
        this.universite = universite;
    }
}
