package com.labo_academy.gestion_bibliotheque.dto.documentDto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DocumentResponseDto {
    private Long id;
    private String title;
    private String documentNumber;
    private LocalDate publicationDate;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;
    private boolean isDeleted;
    private String imageUrl; 
    private String publisher;
    private String categoryName;
    private String authorName;
}
