package com.labo_academy.gestion_bibliotheque.dto.dictionaryDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentResponseDto;

import java.time.LocalDate;

public class DictionaryResponseDto extends DocumentResponseDto {

    private String language;
    private int numberWords;

    public DictionaryResponseDto(Long id, String title, int quantity, LocalDate publicationDate, LocalDate creationDate, LocalDate lastUpdateDate, boolean isDeleted, byte[] image, String publisher, String categoryName, String authorName,String language,int numberWords) {
        super(id, title, quantity, publicationDate, creationDate, lastUpdateDate, isDeleted, image, publisher, categoryName, authorName);
        this.language = language;
        this.numberWords = numberWords;
    }


    // Constructeur


    // Getters and Setters

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberWords() {
        return numberWords;
    }

    public void setNumberWords(int numberWords) {
        this.numberWords = numberWords;
    }


}
