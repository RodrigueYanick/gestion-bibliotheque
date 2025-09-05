package com.labo_academy.gestion_bibliotheque.dto.borrowDto;

import com.labo_academy.gestion_bibliotheque.entity.BorrowedStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BorrowCreateDto {

    private BorrowedStatus status;
    private String documentTitle;
    private String suscribersEmail;

    // CONSTRUCTEUR

    public BorrowCreateDto(BorrowedStatus status, String documentTitle, String suscribersEmail) {
        this.status = status;
        this.documentTitle = documentTitle;
        this.suscribersEmail = suscribersEmail;
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
