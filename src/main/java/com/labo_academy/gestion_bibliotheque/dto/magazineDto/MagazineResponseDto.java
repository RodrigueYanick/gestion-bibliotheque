package com.labo_academy.gestion_bibliotheque.dto.magazineDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MagazineResponseDto extends DocumentResponseDto {

    private String issn;
    private int validationPeriod;

    public MagazineResponseDto(Long id, String title, int quantity, LocalDate publicationDate, LocalDate creationDate, LocalDate lastUpdateDate, boolean isDeleted, byte[] image, String publisher,String issn,int validationPeriod) {
        super(id, title, quantity, publicationDate, creationDate, lastUpdateDate, isDeleted, image, publisher);
        this.issn = issn;
        this.validationPeriod = validationPeriod;
    }

    //  Getter and Setters

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getValidationPeriod() {
        return validationPeriod;
    }

    public void setValidationPeriod(int validationPeriod) {
        this.validationPeriod = validationPeriod;
    }
}
