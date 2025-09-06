package com.labo_academy.gestion_bibliotheque.copyDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CopyCreateDto {
    @NotNull(message = "Le statut emprunté est obligatoire")
    private Boolean borrowed;

    @NotNull(message = "L'identifiant du document est obligatoire")
    private Long documentId;

}
