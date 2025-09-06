package com.labo_academy.gestion_bibliotheque.dto.borrowDto;

import com.labo_academy.gestion_bibliotheque.entity.BorrowedStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class BorrowCreateDto {

    private BorrowedStatus status;
    private String documentMatricule;
    private String subscribersEmail;

    // CONSTRUCTEUR
    public BorrowCreateDto(BorrowedStatus status) {
        this.status = status;
    }

    // Getters and Setters
    public BorrowedStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowedStatus status) {
        this.status = status;
    }
}
