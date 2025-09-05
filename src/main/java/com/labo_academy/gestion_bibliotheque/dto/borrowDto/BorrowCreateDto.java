package com.labo_academy.gestion_bibliotheque.dto.borrowDto;

import com.labo_academy.gestion_bibliotheque.entity.BorrowedStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BorrowCreateDto {

    private BorrowedStatus status;
    private String documentTitle;
    private String documentMatricule;
    private String suscribersEmail;

    // CONSTRUCTEUR

    public BorrowCreateDto(BorrowedStatus status, String documentTitle,String documentMatricule, String suscribersEmail) {
        this.status = status;
        this.documentTitle = documentTitle;
        this.documentMatricule = documentMatricule;
        this.suscribersEmail = suscribersEmail;
    }

    public String getDocumentMatricule() {
        return documentMatricule;
    }

    public void setDocumentMatricule(String documentMatricule) {
        this.documentMatricule = documentMatricule;
    }

    public BorrowedStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowedStatus status) {
        this.status = status;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getSuscribersEmail() {
        return suscribersEmail;
    }

    public void setSuscribersEmail(String suscribersEmail) {
        this.suscribersEmail = suscribersEmail;
    }
}
