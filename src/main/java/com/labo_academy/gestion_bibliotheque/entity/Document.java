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

// Classe abstraite représentant un document dans la bibliothèque
// Utilise l’héritage JPA avec la stratégie JOINED (chaque sous-classe a sa propre table liée par clé primaire)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "document_type", length = 50)
// Colonne utilisée pour différencier les types de documents (Book, Dictionary, etc.)
@Getter
@Setter
@ToString
@Table(name = "document")
@AllArgsConstructor
@NoArgsConstructor
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identifiant unique auto-généré
    private Long id;

    @Column(nullable = false, length = 100)
    // Titre du document (obligatoire)
    private String title;

    @Column(length = 100, unique = true, nullable = false)
    // Matricule unique pour identifier le document
    private String documentNumber;

    @Column(nullable = false, name = "publication_date")
    // Date de publication du document
    private LocalDate publicationDate;

    @Column(nullable = false, name = "creation_date")
    // Date de création (remplie automatiquement avec @PrePersist)
    private LocalDate creationDate;

    @Column(nullable = false, name = "last_update_date")
    // Date de dernière mise à jour (remplie avec @PreUpdate)
    private LocalDate lastUpdateDate;

    @Column(nullable = false, name = "is_deleted")
    // Suppression logique (true = supprimé, false = actif)
    private boolean isDeleted;
    
    // L’URL ou chemin d’accès à l’image de profil.
    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(nullable = false, length = 50)
    // Nom de l’éditeur
    private String publisher;

    // --- Hooks automatiques ---
    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDate.now();
        this.lastUpdateDate = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdateDate = LocalDate.now();
    }

    // --- Relations ---
    @ManyToOne
    @JoinColumn(name = "category_id")
    // Plusieurs documents appartiennent à une seule catégorie
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "document")
    // Un document peut avoir plusieurs exemplaires
    private List<Copy> exemplaires;

    @ManyToOne
    @JoinColumn(name = "author_id")
    // Plusieurs documents peuvent être écrits par un même auteur
    private Author author;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "document")
    // Un document peut avoir plusieurs emprunts
    private List<Borrow> borrows;

    @OneToMany(mappedBy = "document", fetch = FetchType.LAZY)
    // Relation avec Reservation (plusieurs réservations pour un document)
    private List<Reservation> reservations;


}