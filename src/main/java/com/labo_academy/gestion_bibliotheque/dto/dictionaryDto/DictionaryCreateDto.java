package com.labo_academy.gestion_bibliotheque.dto.dictionaryDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;

import java.time.LocalDate;

public class DictionaryCreateDto extends DocumentCreateDto {

    private String language;
    private int numberWords;

    public DictionaryCreateDto(String title, int quantity, LocalDate publicationDate, boolean isDeleted, byte[] image, String publisher, String categoryName, String authorName,String language,int numberWords) {
        super(title, quantity, publicationDate, isDeleted, image, publisher, categoryName, authorName);
        this.language = language;
        this.numberWords = numberWords;
    }

    // Contructeur


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
