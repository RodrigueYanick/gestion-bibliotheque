package com.labo_academy.gestion_bibliotheque.dto.returnedDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter

public class ReturnedResponseDto {

    private Long id;
    private LocalDate returndeDate;

    public ReturnedResponseDto(Long id, LocalDate returndeDate) {
        id = id;
        this.returndeDate = returndeDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public LocalDate getReturndeDate() {
        return returndeDate;
    }

    public void setReturndeDate(LocalDate returndeDate) {
        this.returndeDate = returndeDate;
    }
}
