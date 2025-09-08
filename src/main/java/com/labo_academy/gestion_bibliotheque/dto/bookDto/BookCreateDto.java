package com.labo_academy.gestion_bibliotheque.dto.bookDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateDto extends DocumentCreateDto {

    @NotBlank(message = "L'ISBN est obligatoire")
    @Size(max = 50, message = "L'ISBN doit contenir au maximum 50 caractères")
    private String isbn;

    @Min(value = 1, message = "Le nombre de pages doit être supérieur à 0")
    private int numberPages;
}
