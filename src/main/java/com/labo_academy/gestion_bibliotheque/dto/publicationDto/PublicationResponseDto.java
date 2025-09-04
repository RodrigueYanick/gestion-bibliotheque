package com.labo_academy.gestion_bibliotheque.dto.publicationDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicationResponseDto extends DocumentResponseDto {

    private String universite;

    public PublicationResponseDto(Long id, String title, int quantity, LocalDate publicationDate, LocalDate creationDate, LocalDate lastUpdateDate, boolean isDeleted, byte[] image, String publisher,String universite) {
        super(id, title, quantity, publicationDate, creationDate, lastUpdateDate, isDeleted, image, publisher);
        this.universite = universite;
    }
}
