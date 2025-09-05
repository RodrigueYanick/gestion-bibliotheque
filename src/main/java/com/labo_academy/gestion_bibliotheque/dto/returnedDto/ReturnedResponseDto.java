package com.labo_academy.gestion_bibliotheque.dto.returnedDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter

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
