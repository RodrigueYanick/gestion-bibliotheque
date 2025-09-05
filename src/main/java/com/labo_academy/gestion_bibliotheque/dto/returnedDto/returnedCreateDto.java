package com.labo_academy.gestion_bibliotheque.dto.returnedDto;

public class ReturnedCreateDto {

    private String returendEmail;
    private String documentMatricule;

    public ReturnedCreateDto(String returendEmail, String documentMatricule) {
        this.returendEmail = returendEmail;
        this.documentMatricule = documentMatricule;
    }

    public String getReturendEmail() {
        return returendEmail;
    }

    public void setReturendEmail(String returendEmail) {
        this.returendEmail = returendEmail;
    }

    public String getDocumentMatricule() {
        return documentMatricule;
    }

    public void setDocumentMatricule(String documentMatricule) {
        this.documentMatricule = documentMatricule;
    }
}
