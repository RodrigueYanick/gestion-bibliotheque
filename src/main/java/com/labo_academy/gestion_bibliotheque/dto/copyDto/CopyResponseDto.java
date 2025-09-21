package com.labo_academy.gestion_bibliotheque.dto.copyDto;

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
    private Boolean isBorrowed;
    private String documentNumber;
    private String documentTitle;
}
