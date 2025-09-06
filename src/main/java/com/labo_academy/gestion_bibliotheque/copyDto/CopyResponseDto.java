package com.labo_academy.gestion_bibliotheque.copyDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CopyResponseDto {
    private Long id;
    private Boolean borrowed;
    private String documentMatricule;
    private String documentTitle;
}
