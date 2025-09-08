package com.labo_academy.gestion_bibliotheque.dto.returnedDto;

import java.time.LocalDate;

public class ReturnedResponseDto {

    private Long id;
    private LocalDate returnedDate;

    public ReturnedResponseDto(Long id, LocalDate returnedDate) {
        this.id = id;
        this.returnedDate = returnedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }
}
