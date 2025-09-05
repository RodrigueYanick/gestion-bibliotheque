package com.labo_academy.gestion_bibliotheque.dto.documentDto;

import java.time.LocalDate;

public class DocumentResponseDto {

    private Long id;
    private String title;
    private int quantity;
    private LocalDate publicationDate;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;
    private boolean isDeleted;
    private byte[] image;
    private String publisher;

    private String categoryName;
    private String authorName;

    // Constructeur


    public DocumentResponseDto(Long id, String title, int quantity, LocalDate publicationDate, LocalDate creationDate, LocalDate lastUpdateDate, boolean isDeleted, byte[] image, String publisher,String categoryName,String authorName) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.publicationDate = publicationDate;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.isDeleted = isDeleted;
        this.image = image;
        this.publisher = publisher;
        this.categoryName = categoryName;
        this.authorName = authorName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Getters and Setters


}
