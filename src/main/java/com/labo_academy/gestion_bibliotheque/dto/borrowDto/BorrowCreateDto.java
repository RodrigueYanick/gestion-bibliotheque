package com.labo_academy.gestion_bibliotheque.dto.borrowDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowCreateDto {

    private String documentNumber;   // suffisant pour identifier le document
    private String subscribersEmail;    // permet de retrouver l’abonné

}
