package com.labo_academy.gestion_bibliotheque.dto.sanctionBillDto;

import java.time.LocalDate;

import com.labo_academy.gestion_bibliotheque.entity.SanctionStatus;

public class SanctionBillResponseDto {

    private Long id;
    private String sanctionBillNumber;
    private String subscribersLastName;
    private String subscribersFirstname;
    private String subscribersAddress;
    private String documentMatricule;
    private String documentTitle;
    private LocalDate borrowedDate;
    private LocalDate borrowedReturnDate;
    private LocalDate effectiveReturnedDate;
    private int dateDiff;
    private SanctionStatus status;
    private double amount;

    // Constructeur
    public SanctionBillResponseDto(Long id, String sanctionBillNumber,
                                   String subscribersLastName, String subscribersFirstname, String subscribersAddress,
                                   String documentMatricule, String documentTitle,
                                   LocalDate borrowedDate, LocalDate borrowedReturnDate,
                                   LocalDate effectiveReturnedDate, int dateDiff,
                                   SanctionStatus status, double amount) {
        this.id = id;
        this.sanctionBillNumber = sanctionBillNumber;
        this.subscribersLastName = subscribersLastName;
        this.subscribersFirstname = subscribersFirstname;
        this.subscribersAddress = subscribersAddress;
        this.documentMatricule = documentMatricule;
        this.documentTitle = documentTitle;
        this.borrowedDate = borrowedDate;
        this.borrowedReturnDate = borrowedReturnDate;
        this.effectiveReturnedDate = effectiveReturnedDate;
        this.dateDiff = dateDiff;
        this.status = status;
        this.amount = amount;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSanctionBillNumber() { return sanctionBillNumber; }
    public void setSanctionBillNumber(String sanctionBillNumber) { this.sanctionBillNumber = sanctionBillNumber; }

    public String getSubscribersLastName() { return subscribersLastName; }
    public void setSubscribersLastName(String subscribersLastName) { this.subscribersLastName = subscribersLastName; }

    public String getSubscribersFirstname() { return subscribersFirstname; }
    public void setSubscribersFirstname(String subscribersFirstname) { this.subscribersFirstname = subscribersFirstname; }

    public String getSubscribersAddress() { return subscribersAddress; }
    public void setSubscribersAddress(String subscribersAddress) { this.subscribersAddress = subscribersAddress; }

    public String getDocumentMatricule() { return documentMatricule; }
    public void setDocumentMatricule(String documentMatricule) { this.documentMatricule = documentMatricule; }

    public String getDocumentTitle() { return documentTitle; }
    public void setDocumentTitle(String documentTitle) { this.documentTitle = documentTitle; }

    public LocalDate getBorrowedDate() { return borrowedDate; }
    public void setBorrowedDate(LocalDate borrowedDate) { this.borrowedDate = borrowedDate; }

    public LocalDate getBorrowedReturnDate() { return borrowedReturnDate; }
    public void setBorrowedReturnDate(LocalDate borrowedReturnDate) { this.borrowedReturnDate = borrowedReturnDate; }

    public LocalDate getEffectiveReturnedDate() { return effectiveReturnedDate; }
    public void setEffectiveReturnedDate(LocalDate effectiveReturnedDate) { this.effectiveReturnedDate = effectiveReturnedDate; }

    public int getDateDiff() { return dateDiff; }
    public void setDateDiff(int dateDiff) { this.dateDiff = dateDiff; }

    public SanctionStatus getStatus() { return status; }
    public void setStatus(SanctionStatus status) { this.status = status; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
