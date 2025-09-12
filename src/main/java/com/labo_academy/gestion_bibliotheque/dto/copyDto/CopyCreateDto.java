package com.labo_academy.gestion_bibliotheque.dto.copyDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CopyCreateDto   {

    @NotNull(message = "Le statut de l'exemplaire est obligatoire")
    private Boolean isBorrowed;

    @NotNull(message = "L'identifiant du document est obligatoire")
    @Positive(message = "L'identifiant doit être supérieur à 0")
    private Long documentId;
}
