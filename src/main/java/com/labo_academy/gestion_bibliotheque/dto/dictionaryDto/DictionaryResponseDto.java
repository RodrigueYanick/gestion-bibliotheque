package com.labo_academy.gestion_bibliotheque.dto.dictionaryDto;

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
public class DictionaryResponseDto extends DocumentResponseDto {

    private String language;
    private int numberWords;

    public DictionaryResponseDto(Long id, String title, int quantity, LocalDate publicationDate, LocalDate creationDate, LocalDate lastUpdateDate, boolean isDeleted, byte[] image, String publisher,String language,int numberWords) {
        super(id, title, quantity, publicationDate, creationDate, lastUpdateDate, isDeleted, image, publisher);
        this.language = language;
        this.numberWords = numberWords;
    }

    // Constructeur


    // Getters and Setters

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        language = language;
    }

    public int getNumberWords() {
        return numberWords;
    }

    public void setNumberWords(int numberWords) {
        this.numberWords = numberWords;
    }
}
