package com.labo_academy.gestion_bibliotheque.dto.magazineDto;

import com.labo_academy.gestion_bibliotheque.dto.documentDto.DocumentCreateDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MagazineCreateDto extends DocumentCreateDto {

    private String issn;
    private int validationPeriod;

    public MagazineCreateDto(String title, int quantity, LocalDate publicationDate, boolean isDeleted, byte[] image, String publisher,String issn,int validationPeriod) {
        super(title, quantity, publicationDate, isDeleted, image, publisher);
        this.issn = issn;
        this.validationPeriod = validationPeriod;
    }

    //Getters and Setters
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
