package com.labo_academy.gestion_bibliotheque.dto.bookDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponseDto extends DocumentResponseDto {

    private String isbn;
    private int numberPages;
}
