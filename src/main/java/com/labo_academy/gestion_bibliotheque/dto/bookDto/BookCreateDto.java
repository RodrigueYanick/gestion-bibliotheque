package com.labo_academy.gestion_bibliotheque.dto.bookDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumetCreateDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookCreateDto extends DocumetCreateDto {

    private String isbn;
    private int numberPages;

}
