package com.labo_academy.gestion_bibliotheque.dto.returnedDto;

import java.time.LocalDate;

public class ReturnedResponseDto {

    private Long Id;
    private LocalDate returndeDate;

    public ReturnedResponseDto(Long id, LocalDate returndeDate) {
        Id = id;
        this.returndeDate = returndeDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDate getReturndeDate() {
        return returndeDate;
    }

    public void setReturndeDate(LocalDate returndeDate) {
        this.returndeDate = returndeDate;
    }
}
