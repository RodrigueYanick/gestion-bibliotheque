package com.labo_academy.gestion_bibliotheque.dto.bookDto;

import org.springframework.beans.factory.annotation.Value;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookCreateDto extends DocumentCreateDto {

    @NotBlank(message = "L'isbn est obligatoire")
    @Size(max = 50, min = 10, message = "L'isbn doit contenir entre 10 et 50 caractere")
    private String isbn;
    @Min(value = 1, message = "le nombre de page doit etre superieur a 0")
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
