package com.labo_academy.gestion_bibliotheque.dto.returnedDto;

public class ReturnedCreateDto {

    private String returendEmail;

    public ReturnedCreateDto(String returendEmail) {
        this.returendEmail = returendEmail;
    }

    public String getReturendEmail() {
        return returendEmail;
    }

    public void setReturendEmail(String returendEmail) {
        this.returendEmail = returendEmail;
    }
}
