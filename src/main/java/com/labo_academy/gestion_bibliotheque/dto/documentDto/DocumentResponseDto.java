package com.labo_academy.gestion_bibliotheque.dto.documentDto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DocumentResponseDto {

    private Long id;
    private String title;
    private int quantity;
    private LocalDate publicationDate;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;
    private boolean isDeleted;
    private byte[] image;
    private String publisher;

}
