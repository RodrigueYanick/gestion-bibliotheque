package com.labo_academy.gestion_bibliotheque.dto.bookDto;


import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;

import java.time.LocalDate;

public class BookCreateDto extends DocumentCreateDto {

    private String isbn;
    private int numberPages;

    public BookCreateDto(String title, int quantity, LocalDate publicationDate, boolean isDeleted, byte[] image, String publisher, String isbn, int numberPages) {
        super(title, quantity, publicationDate, isDeleted, image, publisher);
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
