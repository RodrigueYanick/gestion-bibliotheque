package com.labo_academy.gestion_bibliotheque.dto.publicationDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicationCreateDto extends DocumentCreateDto {

    private String universite;

}
