package com.labo_academy.gestion_bibliotheque.dto.bookDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentResponseDto;
import lombok.Getter;

import java.time.LocalDate;
public class BookResponseDto extends DocumentResponseDto {

    private String isbn;
    private int numberPages;

    public BookResponseDto(Long id, String title, int quantity, LocalDate publicationDate, LocalDate creationDate, LocalDate lastUpdateDate, boolean isDeleted, byte[] image, String publisher, String categoryName, String authorName,String isbn,int numberPages) {
        super(id, title, quantity, publicationDate, creationDate, lastUpdateDate, isDeleted, image, publisher, categoryName, authorName);
        this.isbn = isbn;
        this.numberPages = numberPages;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }
}
