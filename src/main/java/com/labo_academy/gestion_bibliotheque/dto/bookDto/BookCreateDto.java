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

}
