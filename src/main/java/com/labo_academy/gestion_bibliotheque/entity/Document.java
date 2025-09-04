package com.labo_academy.gestion_bibliotheque.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Classe abstraite represantant un un document dans une bibliotheque
// utilise l'heritage JPA avec pour strategie JOINED

@Entity  // permet de dire a spring que il sagit d'une table dans la base de donnee
@Inheritance(strategy = InheritanceType.JOINED)  // les sous classe aurons leur propre table lie a la classe mere par la cle primaire
@DiscriminatorColumn(name = "document_type", length = 50)  // aide a l'dentification du type de document dans la base de donnee
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "document")

public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // pour generer automatiquement les identifiant unique
    private Long id;
    @Column(nullable = false, length = 100)  // titre du document obligatoire
    private String title;
    @Column(nullable = false)  // quantite disponible en stock
    private int quantity;
    @Column(nullable = false, name = "publication_date")  // date de publication du document
    private LocalDate publicationDate;
    @Column(nullable = false, name = "creation_date")  // date de creation du document
    private LocalDate creationDate;
    @Column(nullable = false, name = "last_update_date")  // derniere date de mise a jour 
    private LocalDate lastUpdateDate;
    @Column(nullable = false, name = "is_deleted")  // element logique pour la suppression
    private boolean isDeleted;
    @Lob  // perment de stocker des donnee binaire volumineuses(image)
    @Column(nullable = true)
    @ToString.Exclude
    private byte[] image;
    @Column(nullable = false, length = 50)
    private String publisher;

    // Constructeurs
    public Document(Long id, String title, int quantity, LocalDate publicationDate, LocalDate creationDate, LocalDate lastUpdateDate, boolean isDeleted, byte[] image, String publisher, Category category, Author author, List<Borrow> borrows, List<Reservation> reservations) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.publicationDate = publicationDate;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.isDeleted = isDeleted;
        this.image = image;
        this.publisher = publisher;
        this.category = category;
        this.author = author;
        this.borrows = borrows;
        this.reservations = reservations;
    }

    public Document() {

    }

    // Getters and Setters
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

    public boolean getisDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        this.isDeleted = isDeleted;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    // methode appele automatiquement avant la persistance initiale
    @PrePersist
    protected void onCreate(){
        this.creationDate = LocalDate.now();
        this.lastUpdateDate = LocalDate.now();
    }

    // methode appele automatiqument avant chaque mise a jour
    @PreUpdate
    protected void onUpdate(){
        this.lastUpdateDate = LocalDate.now();
    }

    @ManyToOne
    @JoinColumn(name = "category_id")  // relation entre plusieurs document et une category
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id")  // relation entre plusieurs documents et un auteur
    private Author author;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "document")  // relation entre un document et plusieur emprunt
    private List<Borrow> borrows;

    //Relation avec Reservation-Document
    @OneToMany(mappedBy = "documents",fetch = FetchType.LAZY)
    private List<Reservation> reservations ;

}
